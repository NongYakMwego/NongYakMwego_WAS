package nym.nym.crop_pest_disease.adapter.out.persistence;

import nym.nym.crop.adapter.out.persistence.entity.CropEntity;
import nym.nym.crop.domain.Crop;
import nym.nym.pest_disease.adapter.out.persistence.entity.PestDiseaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CropPestDiseaseRepository extends JpaRepository<CropPestDiseaseEntity,Long> {
    boolean existsByCropAndPestDisease(CropEntity crop, PestDiseaseEntity pestDiseaseEntity);
}
