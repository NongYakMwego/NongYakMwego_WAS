package nym.nym.estate.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nym.nym.pesticide_usage.adapter.out.persistence.PesticideUsageEntity;
import nym.nym.user.adapter.out.persistence.UserEntity;
import nym.nym.crop.adapter.out.persistence.entity.CropEntity;
import nym.nym.global.common.entity.BaseEntity;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estate")
public class EstateEntity extends BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @Column(name = "estate_id",nullable = false,unique = true)
    private UUID estateId;

    @Embedded
    private Location location;

    //농약 사용이랑 일대다 양방향
    @OneToMany(mappedBy = "estate",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PesticideUsageEntity> pesticideUsages=new ArrayList<>();

    //농작물이랑 일대다 양방향
    @OneToMany(mappedBy = "estate",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CropEntity> crops=new ArrayList<>();

    //유저랑 다대일 양방향
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity user;
}
