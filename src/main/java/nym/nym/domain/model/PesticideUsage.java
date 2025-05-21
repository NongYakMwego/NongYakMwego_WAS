package nym.nym.domain.model;

import lombok.*;
import nym.nym.pesticide_usage.adapter.out.persistence.UNIT;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class PesticideUsage {
    private UUID usageId;
    private LocalDateTime usedDate;
    private Integer amountUsed;
    private UNIT unit;

    public static PesticideUsage of(LocalDateTime usedDate,Integer amountUsed,UNIT unit){
        return PesticideUsage.builder()
                .usedDate(usedDate)
                .unit(unit)
                .amountUsed(amountUsed)
                .build();
    }

    /**
     * @apiNote 사용 단위 변경 메서드
     * @param  newUnit 시용 단위 입력
     */
    public void changeUnit(UNIT newUnit){
        this.unit=newUnit;
    }

    /**
     * @apiNote 사용량 변경 메서드
     * @param newAmountUsed 변경 사용량
     */
    public void changeAmountUsed(Integer newAmountUsed){
        this.amountUsed=newAmountUsed;
    }

    /**
     * @apiNote 사용 날짜 변경 메서드
     * @param newUsedDate 변경 날짜
     */
    public void changeUsedDate(LocalDateTime newUsedDate){
        this.usedDate=newUsedDate;
    }

}
