package nym.nym.pest_disease.application.port.in;

import nym.nym.pest_disease.adapter.in.web.PestDiseaseResponse;

import java.util.List;

public interface FetchPestDiseaseUseCase {
    List<PestDiseaseResponse> fetchPestDiseaseList(Long cropId);
}
