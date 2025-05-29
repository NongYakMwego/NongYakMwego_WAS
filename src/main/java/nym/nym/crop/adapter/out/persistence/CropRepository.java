package nym.nym.crop.adapter.out.persistence;


import nym.nym.crop.adapter.out.persistence.entity.CropEntity;
import nym.nym.crop.domain.CropInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CropRepository extends JpaRepository<CropEntity,Long> {
    /**
     * @apiNote 작물명과 작물 ID만을 리스트형식으로 반환하는 메서드
     * @param cropName 직물이름
     * @return 작물명과 작물Id 반환
     */
    @Query("SELECT new nym.nym.crop.domain.CropInfo(C.cropId,C.cropDetail.cropName) " +
            "FROM CropEntity AS C " +
            "WHERE C.cropDetail.cropName LIKE  %:cropName% " +
            "ORDER BY C.cropDetail.cropName ASC ")
    List<CropInfo> fetchCropsList(@Param("cropName") String cropName);


    @Query("SELECT C " +
            "FROM CropEntity AS C " +
            "WHERE C.cropId = :cropId ")
    Optional<CropEntity> fetchCropSingle(@Param("cropId") Long cropId);

}
