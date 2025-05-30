package nym.nym.pest_disease.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PestDiseaseRegister {
    private final String pestDiseaseName;
    private final String imaUrl;
    private final String cropName;

    public static PestDiseaseRegister of(
            String pestDiseaseName,
            String imaUrl,
            String cropName
    ) {
        return new PestDiseaseRegister(
                pestDiseaseName,
                imaUrl,
                cropName
        );
    }
}
