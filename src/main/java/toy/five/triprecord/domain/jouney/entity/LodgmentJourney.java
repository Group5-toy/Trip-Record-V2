package toy.five.triprecord.domain.jouney.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import toy.five.triprecord.domain.jouney.dto.request.LodgmentJourneyUpdateRequest;
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

    @Embedded
    private Location LodgmentLocation;

    private void setUpdateName(String name) {
        this.name = name;
    }

    private void setUpdateDormitoryName(String dormitoryName) {
        this.dormitoryName = dormitoryName;
    }

    private void setUpdateLodgeLocation(Location lodgmentLocation) {
        this.LodgmentLocation = lodgmentLocation;
    }

    public void setUpdateColumns(LodgmentJourneyUpdateRequest lodgmentJourneyUpdateRequest, Location lodgeLocation) {
        setUpdateName(lodgmentJourneyUpdateRequest.getName());
        setUpdateDormitoryName(lodgmentJourneyUpdateRequest.getDormitoryName());
        setUpdateStartTime(lodgmentJourneyUpdateRequest.getStartTime());
        setUpdateEndTime(lodgmentJourneyUpdateRequest.getEndTime());
        setUpdateLodgeLocation(lodgeLocation);
    }



}
