package nym.nym.crop.application.port.in;

import nym.nym.crop.adapter.in.web.CropRequest;
import nym.nym.crop.adapter.in.web.CropResponse;

import java.util.List;

public interface FetchCropUseCase {
    List<CropResponse> fetchCropByList(String cropName);
    CropResponse fetchSingleCrop(Long cropId);
}
