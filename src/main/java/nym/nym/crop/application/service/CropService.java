package nym.nym.crop.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.crop.adapter.in.web.CropResponse;
import nym.nym.crop.application.port.in.FetchCropUseCase;
import nym.nym.crop.application.port.out.FetchCropPort;
import nym.nym.crop.domain.Crop;
import nym.nym.crop.adapter.out.persistence.mapper.CropMapper;
import nym.nym.crop.domain.CropInfo;
import nym.nym.global.common.annotaion.CustomLog;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional(readOnly = true)
public class CropService implements  FetchCropUseCase {
    private final FetchCropPort cropFetchPort;
    private final CropMapper cropMapper;


    /**
     * @apiNote 작물 리스트를 반환하는 메서드
     * @param cropName 직물 이름
     * @return 작물 DTO 리스트를 반환합니다.
     */
    @Override
    @CustomLog
    public List<CropResponse> fetchCropByList(String cropName) {
        List<CropInfo> cropResponses= cropFetchPort.fetchCrops(cropName);

        return cropResponses.stream()
                .map(cropInfo -> CropResponse.builder()
                        .cropName(cropInfo.getCropName())
                        .cropId(cropInfo.getCropId())
                        .build())
                .toList();
    }

    @Override
    @CustomLog
    public CropResponse fetchSingleCrop(Long cropId) {
        //1. 조회
        Crop cropResponse=cropFetchPort.fetchCrop(cropId);

        //2. Domain -> Response
        return cropMapper.domainToResponseDto(cropResponse);
    }
}
