package nym.nym.crop.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.crop.adapter.in.web.CropResponse;
import nym.nym.crop.application.port.in.CreateCropCommand;
import nym.nym.crop.application.port.in.CropUseCase;
import nym.nym.crop.application.port.out.CreateCropPort;
import nym.nym.crop.application.port.out.FetchCropPort;
import nym.nym.domain.model.Crop;
import nym.nym.mapper.CropMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CropService implements CropUseCase {
    private final FetchCropPort cropFetchPort;
    private final CreateCropPort createCropPort;
    private final CropMapper cropMapper;

    @Transactional
    @Override
    public CropResponse registerCrop(CreateCropCommand cropCommand) {
        return null;
    }

    /**
     * @apiNote 작물 리스트를 반환하는 메서드
     * @param cropName 직물 이름
     * @return 작물 DTO 리스트를 반환합니다.
     */
    @Transactional(readOnly = true)
    @Override
    public List<CropResponse> fetchCrops(String cropName) {
        List<Crop> cropResponses= cropFetchPort.fetchCrops(cropName);
        log.info("CropService : {}  method : {} ",cropName,"fetchCrops");

        return cropResponses.stream()
                .map(cropMapper::domainToResponseDto)
                .toList();
    }
}
