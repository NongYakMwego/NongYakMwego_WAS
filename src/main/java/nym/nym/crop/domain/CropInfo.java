package nym.nym.crop.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CropInfo {
    private Long cropId;
    private String cropName;

    public static CropInfo of(Long cropId,String cropName){
        return new CropInfo(cropId,cropName);
    }
}
