package nym.nym.crop.application.port.out;

import nym.nym.crop.domain.Crop;

public interface CreateCropPort {
    Crop createCrop(Crop crop);
}
