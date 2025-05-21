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
     * application-port:        1
     * application-service:     2
     * domain:                  3
     * adapter-in:              4
     * adapter:                 5
     * <p>
     * - Error Num
     * 01 ~ 99 (Increasing Num From 01)
     * <p>
     * e.g. review, service, 의 1번 째 정의한 Exception -> 10201
     */
    INTERNAL_SERVER_ERROR(50000,HttpStatus.INTERNAL_SERVER_ERROR,"서버 내부 오류"),
    NOT_FOUND_END_POINT(40400,HttpStatus.NOT_FOUND,"존재하지 않은 API입니다."),

    /**
     * 유효성 검증
     */
    REQUIRE_GREATER_THAN_ZERO_CROP(20101,HttpStatus.BAD_REQUEST,"유효하지 않은 숫자입니다. 1이상 입력해주세요."),
    REQUIRE_IS_NOT_NULL_CROP_NAME(20102,HttpStatus.BAD_REQUEST,"작물 이름 입력 시 빈칸 또는 공백 입력은 불가합니다.");
    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;
}
