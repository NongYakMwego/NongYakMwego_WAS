package nym.nym.pest_disease.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.crop.adapter.out.persistence.CropRepository;
import nym.nym.crop.adapter.out.persistence.entity.CropEntity;
import nym.nym.crop_pest_disease.adapter.out.persistence.CropPestDiseaseEntity;
import nym.nym.crop_pest_disease.adapter.out.persistence.CropPestDiseaseRepository;
import nym.nym.global.common.annotaion.CustomLog;
import nym.nym.global.common.annotaion.PersistenceAdapter;
import nym.nym.global.common.type.ErrorCode;
import nym.nym.global.exception.CustomException;
import nym.nym.pest_disease.adapter.out.persistence.entity.PestDiseaseEntity;
import nym.nym.pest_disease.adapter.out.persistence.mapper.PestDiseaseMapper;
import nym.nym.pest_disease.application.port.out.CreatePestDiseasePort;
import nym.nym.pest_disease.application.port.out.FetchPestDiseasePort;
import nym.nym.pest_disease.domain.PestDisease;
import nym.nym.pest_disease.domain.PestDiseaseRegister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter("pestDiseasePersistenceAdapter")
@Slf4j
public class PestDiseasePersistenceAdapter implements CreatePestDiseasePort, FetchPestDiseasePort {
    private final PestDiseaseRepository pestDiseaseRepository;
    private final PestDiseaseMapper pestDiseaseMapper;
    private final CropRepository cropRepository;
    private final CropPestDiseaseRepository cropPestDiseaseRepository;

    @Override
    @CustomLog
    @Transactional
    public PestDisease createPestDisease(PestDiseaseRegister pestDisease, String cropName) {
        //1. 병해충 도메인->엔티티
        PestDiseaseEntity pestDiseaseEntity = pestDiseaseMapper.domainToEntity(pestDisease);

        //2. 작물 조회
        CropEntity findCrop = cropRepository.findByCropDetail_CropName(cropName)
                .orElse(null);
        if(findCrop==null) return null;

        //3. 병해충 저장 -> 병해충 존재 여부 확인
        PestDiseaseEntity savedPestDisease = pestDiseaseRepository.
                findByPestDiseaseName(pestDiseaseEntity.getPestDiseaseName())
                .orElseGet(() -> pestDiseaseRepository.save(pestDiseaseEntity));


        boolean isAlreadyMapped=cropPestDiseaseRepository.existsByCropAndPestDisease(findCrop,savedPestDisease);

        if (!isAlreadyMapped){
            //4. 작물-병해충 매핑
            CropPestDiseaseEntity cropPestDisease = CropPestDiseaseEntity
                    .builder()
                    .pestDisease(savedPestDisease)
                    .crop(findCrop)
                    .build();
            cropPestDiseaseRepository.save(cropPestDisease);
        }
        return pestDiseaseMapper.entityToDomain(savedPestDisease);
    }

    @Override
    public Page<PestDisease> fetchPestDiseases(Long cropId, Pageable pageable) {
        Page<PestDiseaseEntity> pestDiseaseEntities= pestDiseaseRepository.fetchPestDiseaseList(cropId,pageable);
        return pestDiseaseEntities.map(pestDiseaseMapper::entityToDomain);
    }
}
