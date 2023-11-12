package toy.five.triprecord.domain.trip.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import toy.five.triprecord.domain.trip.dto.request.TripCreateRequest;
import toy.five.triprecord.domain.trip.dto.response.TripCreateResponse;
import toy.five.triprecord.domain.trip.dto.response.TripDetailResponse;
import toy.five.triprecord.domain.trip.service.TripService;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static toy.five.triprecord.domain.trip.entity.Domestic.DOMESTIC;

@WebMvcTest(TripController.class)
@MockBean(JpaMetamodelMappingContext.class)
class TripControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TripService tripService;

    @Autowired
    ObjectMapper mapper;

    protected MediaType contentType =
            new MediaType(MediaType.APPLICATION_JSON.getType(),
                    MediaType.APPLICATION_JSON.getSubtype(),
                    StandardCharsets.UTF_8);

    private final TripDetailResponse defaultTripResponse =
            TripDetailResponse.builder()
                    .id(1L)
                    .name("여행")
                    .startTime(LocalDateTime.of(2022, 1, 1, 0, 0))
                    .endTime(LocalDateTime.of(2023, 1, 1, 0, 0))
                    .domestic(DOMESTIC)
                    .journeys(null)
                    .wishCount(0L)
                    .build();

    @Test
    void createTrip_success() throws Exception {
        //given
        TripCreateRequest tripRequest =
                TripCreateRequest.builder()
                        .name(defaultTripResponse.getName())
                        .domestic(defaultTripResponse.getDomestic())
                        .startTime(defaultTripResponse.getStartTime())
                        .endTime(defaultTripResponse.getEndTime())
                        .build();
        TripCreateResponse tripResponse =
                TripCreateResponse.builder()
                        .id(1L)
                        .name(defaultTripResponse.getName())
                        .domestic(defaultTripResponse.getDomestic())
                        .startTime(defaultTripResponse.getStartTime())
                        .endTime(defaultTripResponse.getEndTime())
                        .likeCount(0L)
                        .build();

        given(tripService.createTrip(any(TripCreateRequest.class)))
                .willReturn(tripResponse);

        //when
        String body = mapper.writeValueAsString(tripRequest);

        //then
        mvc.perform(post("/trips").contentType(contentType).content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(1L))
                .andExpect(jsonPath("$.data.name").value(defaultTripResponse.getName()))
                .andExpect(jsonPath("$.data.domestic").value(String.valueOf(defaultTripResponse.getDomestic())))
                .andExpect(jsonPath("$.data.like_count").value(0L));
    }

}