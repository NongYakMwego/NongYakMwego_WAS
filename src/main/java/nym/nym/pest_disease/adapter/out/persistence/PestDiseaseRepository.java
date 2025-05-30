package nym.nym.pest_disease.adapter.out.persistence;

import nym.nym.pest_disease.adapter.out.persistence.entity.PestDiseaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface PestDiseaseRepository extends JpaRepository<PestDiseaseEntity,Long> {
    Optional<PestDiseaseEntity> findByPestDiseaseName(String pestDiseaseName);
    @Query("SELECT P " +
            "FROM CropPestDiseaseEntity AS C " +
            "JOIN C.pestDisease AS P " +
            "WHERE C.crop.cropId = :cropId " +
            "ORDER BY P.pestDiseaseName ASC")
    Page<PestDiseaseEntity> fetchPestDiseaseList(@Param("cropId")Long cropId, Pageable pageable);
}
