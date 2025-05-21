package nym.nym.crop.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.crop.application.port.out.CreateCropPort;
import nym.nym.crop.application.port.out.FetchCropPort;
import nym.nym.domain.model.Crop;
import nym.nym.mapper.CropMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
@Slf4j
public class CropRepositoryAdapter implements CreateCropPort, FetchCropPort {
    private final CropRepository cropRepository;
    private final CropMapper cropMapper;


    /**
     * @apiNote 작물 목록 조회 메서드
     * @param cropName 작물 이름
     * @return 도메인 향태 작물 리스트 조회
     */
    @Override
    public List<Crop> fetchCrops(String cropName) {
        //1. 작물 엔티티 조회
        log.info("CropRepository : {} method : {}",cropName,"findByCropDetail_CropNameContaining");
        List<CropEntity> cropEntities=cropRepository.findByCropDetail_CropNameContaining(cropName);

        //2. 작물 엔티티 -> 도메인 변경
        log.info("CropRepositoryAdapter : {} method : {}",cropName, "fetchCrops");
        return cropEntities.stream()
                .map(cropMapper::entityToDomain)
                .toList();
    }

    /**
     * @apiNote 작물 생성 메서드
     * @param crop 작물 도메인
     * @return 저장된 작물 도메인 반환
     */
    @Override
    public Crop createCrop(Crop crop) {
        CropEntity cropEntity=cropMapper.domainToEntity(crop);
        CropEntity savedCropEntity=cropRepository.save(cropEntity);
        log.info("CropRepositoryAdapter : {} method : {}",crop, "createCrop");
        return cropMapper.entityToDomain(savedCropEntity);
    }
}
