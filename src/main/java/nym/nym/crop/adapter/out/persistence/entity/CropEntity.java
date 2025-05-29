package nym.nym.crop.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nym.nym.crop_pest.adapter.out.persistence.CropPestEntity;
import nym.nym.estate.adapter.out.persistence.EstateEntity;
import nym.nym.global.common.entity.BaseEntity;
import nym.nym.pesticide.adapter.out.persistence.PesticideEntity;
import nym.nym.pesticide_usage.adapter.out.persistence.PesticideUsageEntity;
import nym.nym.user_crop.adapter.out.persistence.UserCropEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "crop")
public class CropEntity extends BaseEntity {
    @Column(name = "crop_id",nullable = false,unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cropId;

    @Embedded
    private CropDetail cropDetail;

    @Enumerated(EnumType.STRING)
    private CropCategory cropCategory;

    //농약 사용이랑 일대다 양방향
    @OneToMany(mappedBy = "crop",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PesticideUsageEntity> pesticideUsages=new ArrayList<>();

    //농약이랑 일대다 양방향
    @OneToMany(mappedBy = "crop",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PesticideEntity> pesticides=new ArrayList<>();


    //농작물-해충 중간테이블 매핑
    @OneToMany(mappedBy = "crop",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CropPestEntity> cropPests=new ArrayList<>();

    //농작물-유저 중간 테이블 매핑
    @OneToMany(mappedBy = "crop",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<UserCropEntity> userCrops=new ArrayList<>();
}
