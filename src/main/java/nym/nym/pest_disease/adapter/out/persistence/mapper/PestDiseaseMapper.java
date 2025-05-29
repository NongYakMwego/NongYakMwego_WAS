package nym.nym.pest_disease.adapter.out.persistence.mapper;

import nym.nym.pest_disease.adapter.out.persistence.entity.PestDiseaseEntity;
import nym.nym.pest_disease.domain.PestDisease;
import nym.nym.pest_disease.domain.PestDiseaseRegister;

public interface PestDiseaseMapper {
    PestDiseaseEntity domainToEntity(PestDisease pestDisease);
    PestDisease entityToDomain(PestDiseaseEntity pestDisease);
    PestDiseaseEntity domainToEntity(PestDiseaseRegister pestDiseaseRegister);
}
