package nym.nym.pest_disease.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nym.nym.pest_pesticide.adapter.out.persistence.PestPesticideEntity;
import nym.nym.user_pest.adapter.out.persistence.UserPestEntity;
import nym.nym.crop_pest.adapter.out.persistence.CropPestEntity;
import nym.nym.global.common.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pest_disease")
public class PestDiseaseEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pest_disease_id",nullable = false,unique = true)
    private Long pestId;

    @Column(name = "pest_name",nullable = false,length = 50)
    private String pestName;

    @Embedded
    private PestDiseaseName pestDiseaseName;

    @Column(name = "img_url",nullable = true,length = 100)
    private String imgUrl;

    //해충-농약 중간 테이블 매핑
    @OneToMany(mappedBy = "pest",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PestPesticideEntity> pestPesticides=new ArrayList<>();

    //해충-농작물 중간 테이블
    @OneToMany(mappedBy = "pest",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CropPestEntity> cropPests=new ArrayList<>();

    //유저-해충 중간 테이블 매핑
    @OneToMany(mappedBy = "pest",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<UserPestEntity> userPestEntities=new ArrayList<>();

}
