package nym.nym.mapper;

import nym.nym.crop.adapter.out.persistence.CropEntity;
import nym.nym.crop.adapter.in.web.CropRequest;
import nym.nym.crop.adapter.in.web.CropResponse;
import nym.nym.crop.application.port.in.CreateCropCommand;
import nym.nym.domain.model.Crop;

public interface CropMapper {
    CreateCropCommand requestDtoToCommand(CropRequest cropRequest);
    Crop commandToDomain(CreateCropCommand cropCommand);
    CropEntity domainToEntity(Crop crop);
    Crop entityToDomain(CropEntity crop);
    CropResponse domainToResponseDto(Crop crop);
}
