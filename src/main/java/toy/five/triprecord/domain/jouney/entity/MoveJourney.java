package toy.five.triprecord.domain.jouney.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import toy.five.triprecord.domain.jouney.dto.request.MoveJourneyUpdateRequest;
import toy.five.triprecord.domain.trip.entity.Trip;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class MoveJourney extends BaseJourney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String vehicle;

    @Column(nullable = false)
    private String startPoint;

    @Column(nullable = false)
    private String endPoint;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JourneyType type;

    @Embedded
    private Location startLocation;

    @Embedded
    private Location endPointLocation;


    private void setUpdateName(String name) {
        this.name = name;
    }

    private void setUpdateVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    private void setUpdateStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    private void setUpdateEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    private void setUpdateStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    private void setUpdateEndPointLocation(Location endPointLocation) {
        this.endPointLocation = endPointLocation;
    }

    public void setUpdateColumns(MoveJourneyUpdateRequest moveJourneyUpdateRequest,
                                 Location startLocation, Location endPointLocation
    ) {
        setUpdateName(moveJourneyUpdateRequest.getName());
        setUpdateVehicle(moveJourneyUpdateRequest.getVehicle());
        setUpdateStartPoint(moveJourneyUpdateRequest.getStartPoint());
        setUpdateEndPoint(moveJourneyUpdateRequest.getEndPoint());
        setUpdateStartTime(moveJourneyUpdateRequest.getStartTime());
        setUpdateEndTime(moveJourneyUpdateRequest.getEndTime());
        setUpdateStartLocation(startLocation);
        setUpdateEndPointLocation(endPointLocation);
    }



}
