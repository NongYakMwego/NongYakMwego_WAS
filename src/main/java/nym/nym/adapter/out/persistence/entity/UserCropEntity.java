package nym.nym.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nym.nym.global.common.entity.BaseEntity;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCropEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_crop_id",unique = true,nullable = false)
    private Long userCropId;

    //농작물 개수
    @Column(name = "crop_count")
    private Integer cropCount=0;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private CropEntity crop;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private UserEntity user;
}
