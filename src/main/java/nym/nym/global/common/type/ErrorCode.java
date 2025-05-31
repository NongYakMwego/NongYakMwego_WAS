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
     * adapter-out:             5
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
    REQUIRE_IS_NOT_NULL_CROP_NAME(20102,HttpStatus.BAD_REQUEST,"작물 이름 입력 시 빈칸 또는 공백 입력은 불가합니다."),

    /*
    * 작물
    * */
    NOT_EXIST_CROP_ID(200501,HttpStatus.NOT_FOUND,"존재하지 않은 작물입니다."),

    /*
     * 로그인
     */
    EMPTY_KEY_VALUE(160501,HttpStatus.NOT_FOUND,"필수 필드 값이 없습니다."),
    NOT_CHANGE_VALUE(160502,HttpStatus.NOT_FOUND,"값을 숫자로 변환할 수 없습니다."),
    FAIL_KAKAO_TOKEN_PARSING(160503,HttpStatus.BAD_REQUEST,"카카오 토큰 파싱을 실패했습니다."),
    NOT_FIND_KAKAO_ACCESS_TOKEN(160504,HttpStatus.NOT_FOUND,"카카오 엑세스 토큰을 찾을 수 없습니다.");


    ;
    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;
}
