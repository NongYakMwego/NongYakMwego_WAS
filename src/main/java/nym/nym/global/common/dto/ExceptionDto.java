package nym.nym.global.common.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import nym.nym.global.common.type.ErrorCode;

@Getter
public class ExceptionDto {
    @NotNull
    private final Integer code;

    @NotNull
    private final String message;

    public ExceptionDto(ErrorCode errorCode){
        this.code=errorCode.getCode();
        this.message=errorCode.getMessage();
    }
    public static ExceptionDto of(ErrorCode errorCode){
        return new ExceptionDto(errorCode);
    }
}
