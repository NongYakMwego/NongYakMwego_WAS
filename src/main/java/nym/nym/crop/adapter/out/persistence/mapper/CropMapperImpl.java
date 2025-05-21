package nym.nym.crop.adapter.out.persistence.mapper;

import nym.nym.crop.adapter.in.web.CropRequest;
import nym.nym.crop.adapter.in.web.CropResponse;
import nym.nym.crop.adapter.out.persistence.entity.CropDetail;
import nym.nym.crop.adapter.out.persistence.entity.CropEntity;
import nym.nym.crop.application.port.in.CreateCropCommand;
import nym.nym.crop.domain.Crop;
import org.springframework.stereotype.Component;

@Component
public class CropMapperImpl implements CropMapper{
    @Override
    public CreateCropCommand requestDtoToCommand(CropRequest cropRequest) {
        return null;
    }

    @Override
    public Crop commandToDomain(CreateCropCommand cropCommand) {
        return null;
    }

    @Override
    public CropEntity domainToEntity(Crop crop) {
        return CropEntity.builder()
                .cropDetail(new CropDetail(crop.getCropDescription(),crop.getCropName()))
                .build();
    }

    @Override
    public Crop entityToDomain(CropEntity crop) {
        return null;
    }

    @Override
    public CropResponse domainToResponseDto(Crop crop) {
        return null;
    }
}
