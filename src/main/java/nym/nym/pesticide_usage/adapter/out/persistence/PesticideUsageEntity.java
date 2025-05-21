package nym.nym.pesticide_usage.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nym.nym.crop.adapter.out.persistence.CropEntity;
import nym.nym.estate.adapter.out.persistence.EstateEntity;
import nym.nym.global.common.entity.BaseEntity;
import nym.nym.pesticide.adapter.out.persistence.PesticideEntity;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pesticide_usage")
public class PesticideUsageEntity extends BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private UUID usageId;

    //농약 사용 날짜
    @Column(name = "used_date",nullable = false)
    private LocalDateTime usedDate;

    ///농약 사용량
    @Column(name = "amount_used",nullable = false)
    private Integer amountUsed;

    //농약 사용 단위
    @Enumerated(EnumType.STRING)
    @Column(name = "amount_unit",nullable = false)
    private UNIT unit;

    //토지랑 양방향 다대일
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estate_id")
    private EstateEntity estate;

    //농약이랑 양방향 다대일
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pesticide_id")
    private PesticideEntity pesticide;

    //농작물이랑 양방향 다대일
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id")
    private CropEntity crop;
}
