package nym.nym.crop.adapter.in.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.crop.adapter.in.web.CropResponse;
import nym.nym.crop.application.port.in.FetchCropUseCase;
import nym.nym.global.common.annotaion.CustomLog;
import nym.nym.global.common.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/crop")
@Slf4j
public class CropQueryController {
    private final FetchCropUseCase fetchCrops;

    /**
     * @apiNote 작물 정보 여러 건 조회 API
     * @param cropName 작물 이름
     * @return 작물 리스트를 조회한다.
     */
    @GetMapping("/fetch-list")
    @CustomLog
    public ResponseEntity<ApiResponse<List<CropResponse>>> fetchCrops(
            @RequestParam(value = "cropName",defaultValue = "") String cropName
    ){
        List<CropResponse> cropResponses=fetchCrops.fetchCropByList(cropName);
        return ResponseEntity.ok(ApiResponse.ok(cropResponses));
    }

    /**
     * @apiNote 작물 정보 단 건 조회 API
     * @param cropId 작물 Id
     * @return  작물의 세부 정보를 반환
     */
    @GetMapping("/fetch-single")
    @CustomLog
    public ResponseEntity<ApiResponse<CropResponse>> fetchCrop(
            @RequestParam(value = "cropId") Long cropId
    ){
        CropResponse cropResponse=fetchCrops.fetchSingleCrop(cropId);
        return ResponseEntity.ok(ApiResponse.ok(cropResponse));
    }


}
