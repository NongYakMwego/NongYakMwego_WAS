package nym.nym.pest_disease_pesticide.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nym.nym.global.common.entity.BaseEntity;
import nym.nym.pest_disease.adapter.out.persistence.entity.PestDiseaseEntity;
import nym.nym.pesticide.adapter.out.persistence.PesticideEntity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pest_disease_pesticide")
public class PestDiseasePesticideEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pest_disease_pesticide_id",nullable = false,unique = true)
    private Long pestDiseasePesticideId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pesticide_id",nullable = false)
    private PesticideEntity pesticide;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pest_disease_id",nullable = false)
    private PestDiseaseEntity pestDisease;
}
