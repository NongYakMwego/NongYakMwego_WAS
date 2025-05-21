package nym.nym.crop.application.port.in;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import nym.nym.crop.adapter.out.persistence.entity.CropDetail;
import nym.nym.global.common.type.ErrorCode;
import nym.nym.global.exception.CustomException;

@Getter
public class CreateCropCommand {
    /**
     * 입력값 검증 시행
     */
    @NotBlank
    private final CropDetail cropDetail;

    @NotBlank
    private final Integer cropCount;


    public CreateCropCommand(CropDetail cropDetail,Integer cropCount){
        this.cropCount=cropCount;
        this.cropDetail=cropDetail;
        requireNotNull(cropDetail.getCropName());
        requireGreaterThan(cropCount);
    }

    /**
     * @apiNote 작물 등록 시 1개 이상 등록 검증 메서드
     * @param cropCount 작물 등록 개수
     */
    private static void requireGreaterThan(Integer cropCount){
        if(cropCount<=0){
            throw new CustomException(ErrorCode.REQUIRE_GREATER_THAN_ZERO_CROP);
        }
    }

    /**
     * @apiNote 작물 등록 시 작물 이름 검증 메서드
     * @param name 작물 이름
     */
    private static void requireNotNull(String name){
        if(name.isEmpty() || name.isBlank()){
            throw new CustomException(ErrorCode.REQUIRE_IS_NOT_NULL_CROP_NAME);
        }
    }


}
