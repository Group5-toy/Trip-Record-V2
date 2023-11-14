package toy.five.triprecord.domain.jouney.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Location {

    @Column(name = "place_name", insertable = false, updatable = false)
    private String placeName;

    @Column(name = "category_name", insertable = false, updatable = false)
    private String categoryName;

    @Column(name = "address_name", insertable = false, updatable = false)
    private String addressName;

    @Column(name = "road_address_name", insertable = false, updatable = false)
    private String roadAddressName;

    @Column(name = "x", insertable = false, updatable = false)
    private String x;

    @Column(name = "y", insertable = false, updatable = false)
    private String y;

}
