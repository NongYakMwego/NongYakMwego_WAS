package nym.nym.crop.application.port.out;

import nym.nym.crop.domain.Crop;

import java.util.List;

public interface FetchCropPort {
    List<Crop> fetchCrops(String cropName);
}
