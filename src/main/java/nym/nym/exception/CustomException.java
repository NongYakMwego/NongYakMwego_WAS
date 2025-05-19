package nym.nym.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import nym.nym.global.common.type.ErrorCode;

@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException{
    private final ErrorCode errorCode;

    public String getMessage(){
        return errorCode.getMessage();
    }
}
