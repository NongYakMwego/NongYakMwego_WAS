package nym.nym.adapter.out.persistence.repository;


import nym.nym.adapter.out.persistence.entity.CropEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<CropEntity,Long> {

}
