package nym.nym.crop.adapter.in.web;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
/**
 * 작물 등록 DTO
 */
public class CropRequest {
    @NotBlank(message = "작물 이름은 공백 또는 null일 수 없습니다.")
    private String cropName;

    @NotBlank(message = "작물개수는 1개이상이어야 합니다.")
    @Min(1)
    @Max(100000)
    private Integer cropCount;
    //작물 설명은 Null 허용
    private String cropDescription;
}
