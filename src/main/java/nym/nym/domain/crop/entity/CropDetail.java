package nym.nym.domain.crop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CropDetail {
    //작물 설명
    @Lob
    @Column(name = "crop_description", columnDefinition = "TEXT")
    private String cropDescription;

    //농작물 이름
    @Column(name = "crop_name",length = 50,unique = true,nullable = false)
    private String cropName;

    //농작물 개수
    @Column(name = "crop_count")
    private Integer cropCount=0;

    //농작물 개수 감소 함수
    public void decreaseCrop(){
        if(this.cropCount<0){
            this.cropCount=0;
        }
        this.cropCount--;
    }

    //농작물 개수 증가 함수
    public void increaseCrop(){
        this.cropCount++;
    }

    //농작물 이름 변경
    public void changeCropName(String cropName){
        this.cropName=cropName;
    }
}
