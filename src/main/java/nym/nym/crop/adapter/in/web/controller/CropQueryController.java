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
     * @apiNote
     * @param cropName 작물 이름
     * @return 작물 리스트를 조회한다.
     */
    @GetMapping("/fetch-list")
    @CustomLog
    public ResponseEntity<ApiResponse<List<CropResponse>>> fetchCrops(
            @RequestParam(value = "cropName",defaultValue = "") String cropName
    ){
        List<CropResponse> cropResponses=fetchCrops.fetchCropByList(cropName);
        log.info("CropController : {} method : {} ",cropName,"fetchCrop");

        return ResponseEntity.ok(ApiResponse.ok(cropResponses));
    }

    @GetMapping("/fetch-single")
    @CustomLog
    public ResponseEntity<ApiResponse<CropResponse>> fetchCrop(
            @RequestParam("cropId") Long cropId
    ){
        CropResponse cropResponse=fetchCrops.fetchSingleCrop(cropId);
        log.info("CropController : {} method : {} ",cropId,"fetchCropSingle");
        return ResponseEntity.ok(ApiResponse.ok(cropResponse));
    }


}
