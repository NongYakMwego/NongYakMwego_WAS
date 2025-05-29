package nym.nym.pest_disease.adapter.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PestDiseaseName {
    @Column(name = "pest_disease_name_kor",nullable = false,length = 20,unique = true)
    private String pestDiseaseNameKor;

    @Column(name = "pest_disease_name_eng",length = 20,unique = true)
    private String pestDiseaseNameEng;

}
