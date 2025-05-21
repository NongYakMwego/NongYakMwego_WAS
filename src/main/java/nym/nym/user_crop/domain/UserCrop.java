package nym.nym.user_crop.domain;

import lombok.*;
import nym.nym.global.common.type.ErrorCode;
import nym.nym.global.exception.CustomException;

import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserCrop {
    @Getter private final Long userCropId;
    @Getter private final CropCount cropCount;

    public UserCrop withoutId(CropCount cropCount){
        return new UserCrop(null,cropCount);
    }

    public UserCrop withId(Long userCropId,CropCount cropCount){
        return new UserCrop(userCropId,cropCount);
    }

    public Optional<Long> getId(){
        return Optional.ofNullable(this.userCropId);
    }

    public Optional<UserCrop> changeCropCount(CropCount cropCount){
        CropCount newCropCount=this.cropCount.plus(cropCount);
        //입력 변경 작물 수가 음수인 경우
        if(cropCount.isNegative()){
            //변경된 작물 수가 0보다 작아지는 경우->0으로 처리
            if(newCropCount.isNegative()){
                return Optional.of(new UserCrop(this.userCropId,CropCount.ZERO));
            }
        }
        return Optional.of(new UserCrop(this.userCropId,newCropCount));
    }

}
