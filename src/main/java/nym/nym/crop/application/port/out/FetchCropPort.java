package nym.nym.crop.application.port.out;

import nym.nym.crop.domain.Crop;
import nym.nym.crop.domain.CropInfo;

import java.util.List;

public interface FetchCropPort {
    List<CropInfo> fetchCrops(String cropName);
    Crop fetchCrop(Long cropId);
}
