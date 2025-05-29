package nym.nym.pest_disease.application.port.out;

import nym.nym.pest_disease.domain.PestDisease;
import nym.nym.pest_disease.domain.PestDiseaseRegister;

public interface CreatePestDiseasePort {
    PestDisease createPestDisease(PestDiseaseRegister pestDisease, String cropName);
}
