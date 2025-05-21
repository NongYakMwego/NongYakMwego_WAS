package nym.nym.crop.application.port.out;

import nym.nym.domain.model.Crop;

public interface CreateCropPort {
    Crop createCrop(Crop crop);
}
