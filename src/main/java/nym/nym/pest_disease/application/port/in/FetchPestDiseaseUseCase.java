package nym.nym.pest_disease.application.port.in;

import nym.nym.pest_disease.adapter.in.web.PestDiseaseResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FetchPestDiseaseUseCase {
    Page<PestDiseaseResponse> fetchPestDiseaseList(Long cropId, int page,int size);
}
