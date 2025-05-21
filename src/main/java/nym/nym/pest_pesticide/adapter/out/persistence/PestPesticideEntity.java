package nym.nym.pest_pesticide.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nym.nym.global.common.entity.BaseEntity;
import nym.nym.pest.adapter.out.persistence.PestEntity;
import nym.nym.pesticide.adapter.out.persistence.PesticideEntity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pest_pesticide")
public class PestPesticideEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pest_pesticide_id",nullable = false,unique = true)
    private Long pestPesticideId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pesticide_id",nullable = false)
    private PesticideEntity pesticide;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pest_id",nullable = false)
    private PestEntity pest;
}
