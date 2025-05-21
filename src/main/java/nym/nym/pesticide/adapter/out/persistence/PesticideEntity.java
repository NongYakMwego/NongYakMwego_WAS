package nym.nym.pesticide.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nym.nym.pest_pesticide.adapter.out.persistence.PestPesticideEntity;
import nym.nym.pesticide_usage.adapter.out.persistence.PesticideUsageEntity;
import nym.nym.crop.adapter.out.persistence.entity.CropEntity;
import nym.nym.global.common.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pesticide")
public class PesticideEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pesticide_id",unique = true,nullable = false)
    private Long pesticideId;

    @Embedded
    private PesticideDetail pesticideDetail;

    //농약 사용이랑 일대다 양방량 관게
    @OneToMany(mappedBy = "pesticide",cascade =CascadeType.ALL,orphanRemoval = true)
    private List<PesticideUsageEntity> pesticideUsages=new ArrayList<>();

    //농작물이랑 다대일 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id",nullable = false)
    private CropEntity crop;

    @OneToMany(mappedBy = "pesticide",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PestPesticideEntity> pestPesticides=new ArrayList<>();
}
