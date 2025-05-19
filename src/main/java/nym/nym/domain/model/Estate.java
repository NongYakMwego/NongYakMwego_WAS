package nym.nym.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Estate {
    private UUID estateId;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public static Estate of(BigDecimal latitude,BigDecimal longitude){
        return Estate.builder()
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }
}
