package nym.nym.pest_disease.adapter.out.persistence;

import nym.nym.pest_disease.adapter.out.persistence.entity.PestDiseaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PestDiseaseRepository extends JpaRepository<PestDiseaseEntity,Long> {
    Optional<PestDiseaseEntity> findByPestDiseaseName(String pestDiseaseName);
}
