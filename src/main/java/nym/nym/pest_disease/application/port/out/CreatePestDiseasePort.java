package nym.nym.pest_disease.application.port.out;

import nym.nym.pest_disease.domain.PestDisease;

public interface CreatePestDiseasePort {
    PestDisease createPestDisease(PestDisease pestDisease);
}
