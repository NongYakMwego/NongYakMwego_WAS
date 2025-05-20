package nym.nym.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nym.nym.global.common.entity.BaseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "user_pest")
public class UserPestEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_pest_id",unique = true,nullable = false)
    private Long userPestId;

    //유저 테이블과 다대일 매핑
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    //해충 테이블과 다대일 매핑
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pest_id")
    private PestEntity pest;
}
