package nym.nym.pest_disease.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PestDiseaseRegister {
    private final String pestDiseaseNameKor;
    private final String pestDiseaseNameEng;
    private final String imaUrl;
    private final String cropName;

    public static PestDiseaseRegister of(
            String pestDiseaseNameKor,
            String pestDiseaseNameEng,
            String imaUrl,
            String cropName
    ) {
        return new PestDiseaseRegister(
                pestDiseaseNameKor,
                pestDiseaseNameEng,
                imaUrl,
                cropName
        );
    }
}
