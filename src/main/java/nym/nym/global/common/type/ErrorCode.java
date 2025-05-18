package nym.nym.global.common.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    /**
     * - ERROR CODE CONVENTION
     * 00       0           00
     * {Domain} {Package}   {ERROR_NUM}
     * <p>
     * - Domain
     * auth:                  10
     * crop:                  20
     * crop_pest:             30
     * estate:                40
     * pest:                  50
     * pest_pesticide:        11
     * pesticide_recommend:   12
     * pesticide_usage        13
     * sensor                 14
     * sensor_data            15
     * user                   16
     * <p>
     * - Package
     * controller:  1
     * service:     2
     * entity:      3
     * repository:  4
     * dto:         5
     * <p>
     * - Error Num
     * 01 ~ 99 (Increasing Num From 01)
     * <p>
     * e.g. review, service, 의 1번 째 정의한 Exception -> 10201
     */
    INTERNAL_SERVER_ERROR(50000,HttpStatus.INTERNAL_SERVER_ERROR,"서버 내부 오류"),
    NOT_FOUND_END_POINT(40400,HttpStatus.NOT_FOUND,"존재하지 않은 API입니다.");
    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;
}
