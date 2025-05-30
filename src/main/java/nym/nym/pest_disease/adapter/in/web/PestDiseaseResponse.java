package nym.nym.pest_disease.adapter.in.web;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PestDiseaseResponse {
    @NotBlank(message = "병해충 Id는 공백 또는 null일 수 없습니다.")
    private Long pestDiseaseId;

    @NotBlank(message = "병해충 이름은 공백 또는 null일 수 없습니다.")
    private String pestDiseaseName;

    @NotBlank(message = "병해충 이미지는 공백 또는 null일 수 없습니다.")
    private String imageUrl;
}
