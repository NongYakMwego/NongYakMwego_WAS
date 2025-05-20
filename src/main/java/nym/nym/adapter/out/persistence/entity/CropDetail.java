package nym.nym.adapter.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class CropDetail {
    //작물 설명
    @Lob
    @Column(name = "crop_description", columnDefinition = "TEXT")
    private String cropDescription;

    //농작물 이름
    @Column(name = "crop_name",length = 50,unique = true,nullable = false)
    private String cropName;



}
