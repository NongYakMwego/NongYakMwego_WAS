package nym.nym.pest_disease.adapter.out.persistence;

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
    @Column(name = "pest_disease_name_kor",nullable = false,length = 20)
    private String pestDiseaseNameKor;

    @Column(name = "pest_disease_name_eng",nullable = false,length = 20)
    private String pestDiseaseNameEng;

}
