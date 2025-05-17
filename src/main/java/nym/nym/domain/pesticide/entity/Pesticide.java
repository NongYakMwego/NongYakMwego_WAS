package nym.nym.domain.pesticide.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nym.nym.domain.crop.entity.Crop;
import nym.nym.domain.estate.entity.Location;
import nym.nym.domain.pest_pesticide.entity.PestPesticide;
import nym.nym.domain.pesticide_usage.entity.PesticideUsage;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pesticide {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pesticide_id",unique = true,nullable = false)
    private Long pesticideId;

    @Embedded
    private PesticideDetail pesticideDetail;

    //농약 사용이랑 일대다 양방량 관게
    @OneToMany(mappedBy = "pesticide",cascade =CascadeType.ALL,orphanRemoval = true)
    private List<PesticideUsage> pesticideUsages=new ArrayList<>();

    //농작물이랑 다대일 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id",nullable = false)
    private Crop crop;

    @OneToMany(mappedBy = "pesticide",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PestPesticide> pestPesticides=new ArrayList<>();
}
