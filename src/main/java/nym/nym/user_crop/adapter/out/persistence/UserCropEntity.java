package nym.nym.user_crop.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nym.nym.crop.adapter.out.persistence.entity.CropEntity;
import nym.nym.estate.adapter.out.persistence.EstateEntity;
import nym.nym.global.common.entity.BaseEntity;
import nym.nym.user.adapter.out.persistence.UserEntity;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_crop")
public class UserCropEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_crop_id",unique = true,nullable = false)
    private Long userCropId;

    //농작물 개수
    @Column(name = "crop_count")
    private Integer cropCount=0;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "crop_id")
    private CropEntity crop;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "estate_id")
    private EstateEntity estate;
}
