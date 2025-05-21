package nym.nym.crop.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CropInfo {
    private Long cropId;
    private String cropName;

    public static CropInfo of(Long cropId,String cropName){
        return new CropInfo(cropId,cropName);
    }
}
