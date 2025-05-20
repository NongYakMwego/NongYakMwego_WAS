package nym.nym.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nym.nym.domain.model.Pest;
import nym.nym.global.common.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "crop")
public class CropEntity extends BaseEntity {
    @Column(name = "crop_id",nullable = false,unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cropId;

    @Embedded
    private CropDetail cropDetail;

    //농약 사용이랑 일대다 양방향
    @OneToMany(mappedBy = "crop",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PesticideUsageEntity> pesticideUsages=new ArrayList<>();

    //농약이랑 일대다 양방향
    @OneToMany(mappedBy = "crop",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PesticideEntity> pesticides=new ArrayList<>();

    //토지랑 다대일 양방향
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estate_id",nullable = false)
    private EstateEntity estate;

    //농작물-해충 중간테이블 매핑
    @OneToMany(mappedBy = "crop",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CropPestEntity> cropPests=new ArrayList<>();

    //농작물-유저 중간 테이블 매핑
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<UserEntity> users=new ArrayList<>();

    //해충-유저 중간 테이블 매핑
    @OneToMany(mappedBy = "pest",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PestEntity> pests=new ArrayList<>();
}
