package nym.nym.domain.pesticide_usage.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import nym.nym.global.common.entity.BaseEntity;
import nym.nym.global.util.UuidUtil;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor

public class PesticideUsage extends BaseEntity {
    @Id
    @Column(name = "usage_id",unique = true)
    private String usageId;

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

    public PesticideUsage(LocalDateTime usedDate,Integer amountUsed,UNIT unit){
        this.usageId= UuidUtil.createUuid();

    }
}
