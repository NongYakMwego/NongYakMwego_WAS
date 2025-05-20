package nym.nym.mapper;

import nym.nym.adapter.out.persistence.entity.CropEntity;
import nym.nym.application.command.CropCommand;
import nym.nym.domain.crop.dto.CropRequest;
import nym.nym.domain.crop.dto.CropResponse;
import nym.nym.domain.model.Crop;

public interface CropMapper {
    CropCommand requestDtoToCommand(CropRequest cropRequest);
    Crop commandToDomain(CropCommand cropCommand);
    CropEntity domainToEntity(Crop crop);
    Crop entityToDomain(CropEntity crop);
    CropResponse domainToResponseDto(Crop crop);
}
