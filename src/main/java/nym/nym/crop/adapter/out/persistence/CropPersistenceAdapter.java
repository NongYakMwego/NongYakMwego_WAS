package nym.nym.crop.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.crop.adapter.out.persistence.entity.CropEntity;
import nym.nym.crop.adapter.out.persistence.mapper.CropMapper;
import nym.nym.crop.application.port.out.CreateCropPort;
import nym.nym.crop.application.port.out.FetchCropPort;
import nym.nym.crop.domain.Crop;
import nym.nym.crop.domain.CropInfo;
import nym.nym.global.common.PersistenceAdapter;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter("cropPersistenceAdapter")
@Slf4j

public class CropPersistenceAdapter implements CreateCropPort, FetchCropPort {
    private final CropRepository cropRepository;
    private final CropMapper cropMapper;


    /**
     * @apiNote 작물 목록 조회 메서드
     * @param cropName 작물 이름
     * @return 도메인 향태 작물 리스트 조회
     */
    @Override
    public List<CropInfo> fetchCrops(String cropName) {
        //작물Info 엔티티 조회
        log.info("CropRepository : {} method : {}",cropName,"findByCropDetail_CropNameContaining");
        return cropRepository.fetchCropsList(cropName);
    }

    @Override
    public Crop fetchCrop(Long cropId) {
        //1. cropEntity 조회
        CropEntity cropEntity=cropRepository.fetchCropSingle(cropId);
        log.info("CropPersistenceAdapter : {} method : {} ",cropEntity.getCropId(),"fetchCrop");

        //2. crop 도메인으로 변경
        return cropMapper.entityToDomain(cropEntity);
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
