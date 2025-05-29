package nym.nym.pest_disease.adapter.out.persistence.mapper;

import nym.nym.pest_disease.adapter.out.persistence.entity.PestDiseaseEntity;
import nym.nym.pest_disease.adapter.out.persistence.entity.PestDiseaseName;
import nym.nym.pest_disease.domain.PestDisease;
import nym.nym.pest_disease.domain.PestDiseaseRegister;
import org.springframework.stereotype.Component;

@Component
public class PestDiseaseMapperImpl implements PestDiseaseMapper{

    @Override
    public PestDiseaseEntity domainToEntity(PestDisease pestDisease) {
        return PestDiseaseEntity
                .builder()
                .pestDiseaseId(pestDisease.getPestDiseaseId())
                .pestDiseaseName(new PestDiseaseName(pestDisease.getPestDiseaseNameKor(),pestDisease.getPestDiseaseNameEng()))
                .imgUrl(pestDisease.getImaUrl())
                .build();
    }

    @Override
    public PestDisease entityToDomain(PestDiseaseEntity pestDisease) {
        return PestDisease.withId(
                pestDisease.getPestDiseaseId(),
                pestDisease.getPestDiseaseName().getPestDiseaseNameKor(),
                pestDisease.getPestDiseaseName().getPestDiseaseNameEng(),
                pestDisease.getImgUrl()
        );
    }

    @Override
    public PestDiseaseEntity domainToEntity(PestDiseaseRegister pestDiseaseRegister) {
        return PestDiseaseEntity
                .builder()
                .pestDiseaseName(new PestDiseaseName(pestDiseaseRegister.getPestDiseaseNameKor(),pestDiseaseRegister.getPestDiseaseNameEng()))
                .imgUrl(pestDiseaseRegister.getImaUrl())
                .build();
    }
}
