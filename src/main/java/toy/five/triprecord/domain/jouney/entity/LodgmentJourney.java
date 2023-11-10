package toy.five.triprecord.domain.jouney.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import toy.five.triprecord.domain.jouney.dto.request.LodgmentJourneyUpdateRequest;
import toy.five.triprecord.domain.jouney.dto.request.MoveJourneyUpdateRequest;
import toy.five.triprecord.domain.trip.entity.Trip;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class LodgmentJourney extends BaseJourney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne  // mappedBy는 주인 쪽만
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String dormitoryName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JourneyType type;


    private void setUpdateName(String name) {
        this.name = name;
    }

    private void setUpdateDormitoryName(String dormitoryName) {
        this.dormitoryName = dormitoryName;
    }

    public void setUpdateColumns(LodgmentJourneyUpdateRequest lodgmentJourneyUpdateRequest) {
        setUpdateName(lodgmentJourneyUpdateRequest.getName());
        setUpdateDormitoryName(lodgmentJourneyUpdateRequest.getDormitoryName());
        setUpdateStartTime(lodgmentJourneyUpdateRequest.getStartTime());
        setUpdateEndTime(lodgmentJourneyUpdateRequest.getEndTime());
    }



}
