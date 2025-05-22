package nym.nym.estate.adapter.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    //위도
    @Column(name = "latitude",precision = 10,scale = 6)
    private BigDecimal latitude;

    //경도
    @Column(name = "logitude",precision = 10,scale = 6)
    private BigDecimal longitude;

}
