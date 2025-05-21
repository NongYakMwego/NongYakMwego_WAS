package nym.nym.crop.adapter.in.web;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class CropResponse {
    @NotBlank(message = "작물 Id는 공백 또는 null일 수 없습니다.")
    private Long cropId;

    @NotBlank(message = "작물 이름은 공백 또는 null일 수 없습니다.")
    private String cropName;
    //작물 설명은 Null 허용
    private String cropDescription;

    //작물 조회 시 유저가 키우지 않는 작물도 조회 가능 하도록 0설정.
    @NotBlank(message = "작물 개수는 0개 이상입니다.")
    private Integer cropCount;
}
