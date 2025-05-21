package nym.nym.crop.domain;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Crop {
    private Long cropId;
    private String cropDescription;
    private String cropName;

    public static Crop withoutId(String cropDescription,String cropName){
        return new Crop(null,cropDescription,cropName);
    }

    public static Crop withId(Long cropId,String cropDescription,String cropName){
        return new Crop(cropId,cropDescription,cropName);
    }
}
