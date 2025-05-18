package nym.nym.domain.crop.util;

import nym.nym.domain.crop.dto.CropRequest;
import nym.nym.domain.crop.dto.CropResponse;
import nym.nym.domain.crop.entity.Crop;
import nym.nym.domain.crop.entity.CropDetail;

public class CropMapper {
    public static Crop toEntity(CropRequest request){
        return Crop.builder()
                .cropDetail(new CropDetail(request.getCropDescription(),
                        request.getCropName(),
                        request.getCropCount())
                )
                .build();
    }

    public static CropResponse toDto(Crop crop){
        return CropResponse.builder()
                .cropId(crop.getCropId())
                .cropDescription(crop.getCropDetail().getCropDescription())
                .cropCount(crop.getCropDetail().getCropCount())
                .cropName(crop.getCropDetail().getCropName())
                .build();
    }
}
