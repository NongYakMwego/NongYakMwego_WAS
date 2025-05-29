package nym.nym.crop.adapter.in.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CropResponse {
    @NotBlank(message = "작물 Id는 공백 또는 null일 수 없습니다.")
    private Long cropId;

    @NotBlank(message = "작물 이름은 공백 또는 null일 수 없습니다.")
    private String cropName;

    @NotBlank(message = "작물 카테고리는 공백 또는 null일 수 없습니다.")
    private String category;

    //작물 설명은 Null 허용
    private String cropDescription;

}
