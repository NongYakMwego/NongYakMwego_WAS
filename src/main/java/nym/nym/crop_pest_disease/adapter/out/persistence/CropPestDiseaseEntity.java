package nym.nym.crop_pest_disease.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import nym.nym.pest_disease.adapter.out.persistence.entity.PestDiseaseEntity;
import nym.nym.crop.adapter.out.persistence.entity.CropEntity;
import nym.nym.global.common.entity.BaseEntity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "crop_pest_disease")
public class CropPestDiseaseEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "crop_pest_disease_id",nullable = false,unique = true)
    private Long cropPestDiseaseId;

    @Enumerated(EnumType.STRING)
    @Column(name = "severity_level")
    private LEVEL level;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "crop_id",nullable = false)
    private CropEntity crop;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pest_disease_id",nullable = false)
    private PestDiseaseEntity pestDisease;
}
