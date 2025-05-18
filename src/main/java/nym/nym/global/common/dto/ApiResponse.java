package nym.nym.global.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatus;

public record ApiResponse<T> (
        @JsonIgnore
        HttpStatus status,
        boolean success,
        @JsonInclude(JsonInclude.Include.NON_NULL) T data,
        @JsonInclude(JsonInclude.Include.NON_NULL) ExceptionDto error
){
    //데이터 포함 생성자
    public static <T> ApiResponse<T> ok(@Nullable final T data){
        return new ApiResponse<T>(HttpStatus.OK,true,data,null);
    }

    //데이터 포함x 생성자
    public static <T> ApiResponse<T> okWithOutData(){
        return new ApiResponse<T>(HttpStatus.OK,true,null,null);
    }

    //생성 응답 생성자
    public static <T> ApiResponse<T> created(@Nullable final T data){
        return new ApiResponse<T>(HttpStatus.CREATED,true,data,null);
    }

    //실패 응답 생성자
    public static <T> ApiResponse<T> fail(final CustomException e){

    }


}
