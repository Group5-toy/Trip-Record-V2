package toy.five.triprecord.domain.wish.conroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import toy.five.triprecord.domain.trip.dto.request.TripCreateRequest;
import toy.five.triprecord.domain.trip.entity.Domestic;
import toy.five.triprecord.domain.trip.service.TripService;
import toy.five.triprecord.domain.user.dto.request.UserCreateRequest;
import toy.five.triprecord.domain.user.dto.request.UserGetRequest;
import toy.five.triprecord.domain.user.service.UserService;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static toy.five.triprecord.domain.trip.entity.Domestic.DOMESTIC;

@SpringBootTest
@AutoConfigureMockMvc
class WishControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
//    @MockBean
    private UserService userService;

    @Autowired
    private TripService tripService;

    protected MediaType contentType =
            new MediaType(MediaType.APPLICATION_JSON.getType(),
                    MediaType.APPLICATION_JSON.getSubtype(),
                    StandardCharsets.UTF_8);

//    @BeforeEach
    void before() {
        UserCreateRequest userCreateRequest =
                UserCreateRequest.builder()
                        .email("test@test.com")
                        .password("test")
                        .name("test")
                        .build();
        userService.createUser(userCreateRequest);

        TripCreateRequest tripCreateRequest =
                TripCreateRequest.builder()
                        .name("여행")
                        .domestic(DOMESTIC)
                        .startTime(LocalDateTime.now())
                        .endTime(LocalDateTime.now())
                        .build();
        tripService.createTrip(tripCreateRequest);
    }

    void after() {

    }

    @Test
    void wishTrip_success() throws Exception {

        UserCreateRequest userCreateRequest =
                UserCreateRequest.builder()
                        .email("test@test.com")
                        .password("@@Test123")
                        .name("test")
                        .build();
        String body1 = mapper.writeValueAsString(userCreateRequest);

        mvc.perform(post("/users")
                        .contentType(contentType)
                        .content(body1))
                .andDo(print());

        UserGetRequest userGetRequest = UserGetRequest.builder().email("test@test.com").build();
        String body2 = mapper.writeValueAsString(userGetRequest);

        mvc.perform(get("/users")
                        .contentType(contentType)
                        .content(body2))
                .andDo(print());
    }


}