package nym.nym.domain.pest_pesticide.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nym.nym.domain.pest.entity.Pest;
import nym.nym.domain.pesticide.entity.Pesticide;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PestPesticide {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pest_pesticide_id",nullable = false,unique = true)
    private Long pestPesticideId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pesticide_id",nullable = false)
    private Pesticide pesticide;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pest_id",nullable = false)
    private Pest pest;
}
