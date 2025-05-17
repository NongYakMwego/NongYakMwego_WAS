package nym.nym.domain.crop_pest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nym.nym.domain.crop.entity.Crop;
import nym.nym.domain.pest.entity.Pest;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CropPest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "crop_pest_id",nullable = false,unique = true)
    private Long cropPestId;

    @Enumerated(EnumType.STRING)
    @Column(name = "severity_level")
    private LEVEL level;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "crop_id",nullable = false)
    private Crop crop;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pest_id",nullable = false)
    private Pest pest;
}
