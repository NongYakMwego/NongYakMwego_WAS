package nym.nym.crop_pest.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nym.nym.pest.adapter.out.persistence.PestEntity;
import nym.nym.crop.adapter.out.persistence.entity.CropEntity;
import nym.nym.global.common.entity.BaseEntity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "crop_pest")
public class CropPestEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "crop_pest_id",nullable = false,unique = true)
    private Long cropPestId;

    @Enumerated(EnumType.STRING)
    @Column(name = "severity_level")
    private LEVEL level;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "crop_id",nullable = false)
    private CropEntity crop;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pest_id",nullable = false)
    private PestEntity pest;
}
