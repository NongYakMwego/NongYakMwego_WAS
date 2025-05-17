package nym.nym.domain.crop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nym.nym.global.common.entity.BaseEntity;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Crop extends BaseEntity {
    @Column(name = "crop_id",nullable = false,unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cropId;

    @Embedded
    private CropDetail cropDetail;
}
