package nym.nym.user_pest_disease.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nym.nym.global.common.entity.BaseEntity;
import nym.nym.pest_disease.adapter.out.persistence.entity.PestDiseaseEntity;
import nym.nym.user.adapter.out.persistence.UserEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "user_pest_disease")
public class UserPestDiseaseEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_pest_disease_id",unique = true,nullable = false)
    private Long userPestDiseaseId;

    //유저 테이블과 다대일 매핑
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    //해충 테이블과 다대일 매핑
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pest_disease_id")
    private PestDiseaseEntity pestDisease;
}
