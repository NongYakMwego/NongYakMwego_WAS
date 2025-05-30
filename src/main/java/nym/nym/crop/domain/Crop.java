package nym.nym.crop.domain;

import lombok.*;
import nym.nym.crop.adapter.out.persistence.entity.CropCategory;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Crop {
    @Getter
    private Long cropId;
    @Getter
    private String cropDescription;
    @Getter
    private String cropName;
    @Getter
    private CropCategory cropCategory;

    public static Crop withoutId(String cropDescription,String cropName,CropCategory cropCategory){
        return new Crop(null,cropDescription,cropName,cropCategory);
    }

    public static Crop withId(Long cropId,String cropDescription,String cropName,CropCategory cropCategory){
        return new Crop(cropId,cropDescription,cropName,cropCategory);
    }
}
