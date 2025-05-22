package nym.nym.user_crop.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class CropCount {
    public static CropCount ZERO = CropCount.of(0);
    @NotNull
    private final Integer cropCount;

    public static CropCount of(int value){
        return new CropCount(value);
    }

    public boolean isPositiveOrZero(){
        return this.cropCount>=0;
    }

    public boolean isNegative(){
        return this.cropCount<0;
    }

    public boolean isPositive(){
        return this.cropCount>0;
    }

    public boolean isGreaterThanOrEqualTo(CropCount cropCount){
        return this.cropCount.compareTo(cropCount.cropCount)>=0;
    }
    public boolean isGreaterThan(CropCount cropCount){
        return this.cropCount.compareTo(cropCount.cropCount)>=1;
    }

    public CropCount add(CropCount a, CropCount b){
        return new CropCount(a.cropCount+b.cropCount);
    }
    public CropCount minus(CropCount a,CropCount b){
        return new CropCount(Math.abs(a.cropCount-b.cropCount));
    }
    public CropCount plus(CropCount cropCount){
        return new CropCount(this.cropCount+cropCount.cropCount);
    }
}
