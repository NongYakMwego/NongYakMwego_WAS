package nym.nym.domain.crop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nym.nym.domain.crop_pest.entity.CropPest;
import nym.nym.domain.estate.entity.Estate;
import nym.nym.domain.pesticide.entity.Pesticide;
import nym.nym.domain.pesticide_usage.entity.PesticideUsage;
import nym.nym.global.common.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Crop extends BaseEntity {
    @Column(name = "crop_id",nullable = false,unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cropId;

    @Embedded
    private CropDetail cropDetail;

    //농약 사용이랑 일대다 양방향
    @OneToMany(mappedBy = "crop",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PesticideUsage> pesticideUsages=new ArrayList<>();

    //농약이랑 일대다 양방향
    @OneToMany(mappedBy = "crop",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Pesticide> pesticides=new ArrayList<>();

    //토지랑 다대일 양방향
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estate_id",nullable = false)
    private Estate estate;

    //농작물-해충 중간테이블 매핑
    @OneToMany(mappedBy = "crop",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CropPest> cropPests=new ArrayList<>();
}
