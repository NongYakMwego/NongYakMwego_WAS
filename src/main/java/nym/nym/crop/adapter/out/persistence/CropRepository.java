package nym.nym.crop.adapter.out.persistence;


import nym.nym.crop.adapter.out.persistence.CropEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CropRepository extends JpaRepository<CropEntity,Long> {
    List<CropEntity> findByCropDetail_CropNameContaining(String cropName);
}
