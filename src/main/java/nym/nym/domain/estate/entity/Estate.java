package nym.nym.domain.estate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nym.nym.domain.auth.entity.User;
import nym.nym.domain.crop.entity.Crop;
import nym.nym.domain.pesticide_usage.entity.PesticideUsage;
import nym.nym.global.common.entity.BaseEntity;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Estate extends BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @Column(name = "estate_id",nullable = false,unique = true)
    private UUID estateId;

    @Embedded
    private Location location;

    //농약 사용이랑 일대다 양방향
    @OneToMany(mappedBy = "estate",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PesticideUsage> pesticideUsages=new ArrayList<>();

    //농작물이랑 일대다 양방향
    @OneToMany(mappedBy = "estate",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Crop> crops=new ArrayList<>();

    //유저랑 다대일 양방향
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}
