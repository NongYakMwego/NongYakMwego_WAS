package nym.nym.domain.pesticide_usage.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import nym.nym.global.common.entity.BaseEntity;
import nym.nym.global.util.UuidUtil;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor

public class PesticideUsage extends BaseEntity {
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

    public PesticideUsage(LocalDateTime usedDate,Integer amountUsed,UNIT unit){
        this.usageId= UuidUtil.createUuid();

    }
}
