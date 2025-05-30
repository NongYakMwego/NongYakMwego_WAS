package nym.nym.pest_disease.application.port.out;

import nym.nym.pest_disease.domain.PestDisease;

import java.util.List;

public interface FetchPestDiseasePort {
    List<PestDisease> fetchPestDiseases(Long cropId);
}
