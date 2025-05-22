package nym.nym.pesticide.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Pesticide {
    private Long pesticideId;
    private String pesticideName;
    private Integer dilutionRatio;
    private String salesSiteUrl;
    private String riskDescription;

    public static Pesticide of(String pesticideName,Integer dilutionRatio,String salesSiteUrl,String riskDescription){
        return Pesticide.builder()
                .pesticideName(pesticideName)
                .dilutionRatio(dilutionRatio)
                .salesSiteUrl(salesSiteUrl)
                .riskDescription(riskDescription)
                .build();
    }
}
