package nym.nym.pest_disease.application.port.out;

import nym.nym.pest_disease.domain.PestDisease;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FetchPestDiseasePort {
    Page<PestDisease> fetchPestDiseases(Long cropId, Pageable pageable);
}
