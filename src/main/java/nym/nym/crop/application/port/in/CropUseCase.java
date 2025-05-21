package nym.nym.crop.application.port.in;

import nym.nym.crop.adapter.in.web.CropResponse;

public interface CropUseCase {
    CropResponse registerCrop(CreateCropCommand cropCommand);
}
