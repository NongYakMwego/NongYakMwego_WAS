package nym.nym.domain.model;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Crop {
    private Long cropId;
    private String cropDescription;
    private String cropName;

    public static Crop of(String cropDescription,String cropName){
        return Crop.builder()
                .cropDescription(cropDescription)
                .cropName(cropName)
                .build();
    }
}
