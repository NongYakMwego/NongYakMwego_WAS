package nym.nym.crop.adapter.out.persistence.mapper;

import nym.nym.crop.adapter.in.web.CropRequest;
import nym.nym.crop.adapter.in.web.CropResponse;
import nym.nym.crop.adapter.out.persistence.entity.CropDetail;
import nym.nym.crop.adapter.out.persistence.entity.CropEntity;
import nym.nym.crop.domain.Crop;
import org.springframework.stereotype.Component;

@Component
public class CropMapperImpl implements CropMapper{
    @Override
    public CropEntity domainToEntity(Crop crop) {
        return CropEntity.builder()
                .cropDetail(new CropDetail(crop.getCropDescription(),crop.getCropName()))
                .cropCategory(crop.getCropCategory())
                .build();
    }

    @Override
    public Crop entityToDomain(CropEntity crop) {
        return Crop.withId(crop.getCropId()
                ,crop.getCropDetail().getCropDescription()
                ,crop.getCropDetail().getCropName()
                ,crop.getCropCategory()
        );
    }

    @Override
    public CropResponse domainToResponseDto(Crop crop) {
        return CropResponse.builder()
                .cropName(crop.getCropName())
                .cropId(crop.getCropId())
                .cropDescription(crop.getCropDescription())
                .category(crop.getCropCategory().getMsg())
                .build();

    }
}
