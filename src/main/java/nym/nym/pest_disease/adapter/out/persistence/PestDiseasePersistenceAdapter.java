package nym.nym.pest_disease.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.crop.adapter.out.persistence.CropRepository;
import nym.nym.crop.adapter.out.persistence.entity.CropEntity;
import nym.nym.crop_pest_disease.adapter.out.persistence.CropPestDiseaseEntity;
import nym.nym.crop_pest_disease.adapter.out.persistence.CropPestDiseaseRepository;
import nym.nym.global.common.annotaion.PersistenceAdapter;
import nym.nym.global.common.type.ErrorCode;
import nym.nym.global.exception.CustomException;
import nym.nym.pest_disease.adapter.out.persistence.entity.PestDiseaseEntity;
import nym.nym.pest_disease.adapter.out.persistence.mapper.PestDiseaseMapper;
import nym.nym.pest_disease.application.port.out.CreatePestDiseasePort;
import nym.nym.pest_disease.domain.PestDisease;
import nym.nym.pest_disease.domain.PestDiseaseRegister;

@RequiredArgsConstructor
@PersistenceAdapter("pestDiseasePersistenceAdapter")
@Slf4j
public class PestDiseasePersistenceAdapter implements CreatePestDiseasePort {
    private final PestDiseaseRepository pestDiseaseRepository;
    private final PestDiseaseMapper pestDiseaseMapper;
    private final CropRepository cropRepository;
    private final CropPestDiseaseRepository cropPestDiseaseRepository;

    @Override
    public PestDisease createPestDisease(PestDiseaseRegister pestDisease, String cropName) {
        //1. 병해충 도메인->엔티티
        PestDiseaseEntity pestDiseaseEntity=pestDiseaseMapper.domainToEntity(pestDisease);

        //2. 작물 조회
        CropEntity findCrop=cropRepository.findByCropDetail_CropName(cropName)
                .orElseThrow(()->new CustomException(ErrorCode.NOT_EXIST_CROP_ID));

        //3. 병해충 저장
        PestDiseaseEntity savedPestDisease=pestDiseaseRepository.save(pestDiseaseEntity);

        //4. 작물-병해충 매핑
        CropPestDiseaseEntity cropPestDisease=CropPestDiseaseEntity
                .builder()
                .pestDisease(savedPestDisease)
                .crop(findCrop)
                .build();

        cropPestDiseaseRepository.save(cropPestDisease);

        return pestDiseaseMapper.entityToDomain(savedPestDisease);
    }
}
