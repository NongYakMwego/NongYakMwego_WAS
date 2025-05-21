package nym.nym.mapper;

import nym.nym.crop.adapter.out.persistence.CropDetail;
import nym.nym.crop.adapter.out.persistence.CropEntity;
import nym.nym.application.port.in.command.CropCommand;
import nym.nym.crop.adapter.in.web.CropRequest;
import nym.nym.crop.adapter.in.web.CropResponse;
import nym.nym.domain.model.Crop;

public class CropMapperImpl implements CropMapper{
    @Override
    public CropCommand requestDtoToCommand(CropRequest cropRequest) {
        return null;
    }

    @Override
    public Crop commandToDomain(CropCommand cropCommand) {
        return null;
    }

    @Override
    public CropEntity domainToEntity(Crop crop) {
        return CropEntity.builder()
                .cropId(crop.getCropId())
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
