package nym.nym.domain.pest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nym.nym.domain.crop_pest.entity.CropPest;
import nym.nym.domain.pest_pesticide.entity.PestPesticide;
import nym.nym.global.common.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pest extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pest_id",nullable = false,unique = true)
    private Long pestId;

    @Column(name = "pest_name",nullable = false,length = 50)
    private String pestName;

    //해충-농약 중간 테이블 매핑
    @OneToMany(mappedBy = "pest",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PestPesticide> pestPesticides=new ArrayList<>();

    //해충-농작물 중간 테이블
    @OneToMany(mappedBy = "pest",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CropPest> cropPests=new ArrayList<>();
}
