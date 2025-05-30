package nym.nym.pest_disease.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nym.nym.pest_disease_pesticide.adapter.out.persistence.PestDiseasePesticideEntity;
import nym.nym.user_pest_disease.adapter.out.persistence.UserPestDiseaseEntity;
import nym.nym.crop_pest_disease.adapter.out.persistence.CropPestDiseaseEntity;
import nym.nym.global.common.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "pest_disease")
public class PestDiseaseEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pest_disease_id",nullable = false,unique = true)
    private Long pestDiseaseId;

    @Column(name = "pest_disease_name",nullable = false,length = 512,unique = true)
    private String pestDiseaseName;

    @Column(name = "img_url",length = 1024)
    private String imgUrl;

    //해충-농약 중간 테이블 매핑
    @OneToMany(mappedBy = "pestDisease",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PestDiseasePesticideEntity> pestDiseasePesticides=new ArrayList<>();

    //해충-농작물 중간 테이블
    @OneToMany(mappedBy = "pestDisease",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CropPestDiseaseEntity> cropPestDiseases=new ArrayList<>();

    //유저-해충 중간 테이블 매핑
    @OneToMany(mappedBy = "pestDisease",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<UserPestDiseaseEntity> userPestEntities=new ArrayList<>();

}
