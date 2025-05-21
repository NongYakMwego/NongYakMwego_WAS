package nym.nym.crop.adapter.in.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.crop.adapter.in.web.CropResponse;
import nym.nym.crop.application.port.in.FetchCropUseCase;
import nym.nym.global.common.dto.ApiResponse;
import nym.nym.mapper.CropMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/crop")
@Slf4j
public class CropQueryController {
    private final FetchCropUseCase fetchCrops;
    private final CropMapper cropMapper;
    /**
     * @param cropName 작물 이름
     * @param header JWT
     * @return 작물 리스트를 조회한다.
     */
    @GetMapping("/fetch")
    public ResponseEntity<ApiResponse<List<CropResponse>>> fetchCrop(
            @RequestParam("crop-name") String cropName,
            @RequestHeader("Authorization") String header
    ){
        List<CropResponse> cropResponses=fetchCrops.fetchCropByList(cropName);
        log.info("CropController : {} method : {} Header : {}",cropName,"fetchCrop",header);

        return ResponseEntity.ok(ApiResponse.ok(cropResponses));
    }
}
