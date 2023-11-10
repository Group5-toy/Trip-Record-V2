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

    public void setUpdateColumns(MoveJourneyUpdateRequest moveJourneyUpdateRequest) {
        setUpdateName(moveJourneyUpdateRequest.getName());
        setUpdateVehicle(moveJourneyUpdateRequest.getVehicle());
        setUpdateStartPoint(moveJourneyUpdateRequest.getStartPoint());
        setUpdateEndPoint(moveJourneyUpdateRequest.getEndPoint());
        setUpdateStartTime(moveJourneyUpdateRequest.getStartTime());
        setUpdateEndTime(moveJourneyUpdateRequest.getEndTime());
    }



}
