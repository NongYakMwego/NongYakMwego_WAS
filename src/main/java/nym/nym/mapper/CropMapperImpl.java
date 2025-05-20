package nym.nym.mapper;

import nym.nym.adapter.out.persistence.entity.CropEntity;
import nym.nym.application.command.CropCommand;
import nym.nym.domain.crop.dto.CropRequest;
import nym.nym.domain.crop.dto.CropResponse;
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
        return null;
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
