package nym.nym.pest_disease.adapter.out.persistence.mapper;

import nym.nym.pest_disease.adapter.out.persistence.entity.PestDiseaseEntity;
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
                .pestDiseaseName(pestDisease.getPestDiseaseName())
                .imgUrl(pestDisease.getImaUrl())
                .build();
    }

    @Override
    public PestDisease entityToDomain(PestDiseaseEntity pestDisease) {
        return PestDisease.withId(
                pestDisease.getPestDiseaseId(),
                pestDisease.getPestDiseaseName(),
                pestDisease.getImgUrl()
        );
    }

    @Override
    public PestDiseaseEntity domainToEntity(PestDiseaseRegister pestDiseaseRegister) {
        return PestDiseaseEntity
                .builder()
                .pestDiseaseName(pestDiseaseRegister.getPestDiseaseName())
                .imgUrl(pestDiseaseRegister.getImaUrl())
                .build();
    }
}
