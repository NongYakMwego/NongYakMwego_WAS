package nym.nym.domain.crop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nym.nym.domain.crop.vo.CropDetail;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Crop {
    @Column(name = "crop_id",nullable = false,unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cropId;

    @Embedded
    private CropDetail cropDetail;
}
