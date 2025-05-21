package nym.nym.crop.adapter.in.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.crop.application.port.in.CreateCropCommand;
import nym.nym.crop.application.port.in.CropUseCase;
import nym.nym.global.common.dto.ApiResponse;
import nym.nym.mapper.CropMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crop")
@Slf4j
public class CropController {
    private final CropUseCase cropUseCase;
    private final CropMapper cropMapper;

    /**
     *
     * @param request 작물 등록 DTO
     * @param header JWT
     * @return 작물 등록 요청을 받아 새 작물을 등록 한다.
     */
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<CropResponse>> registerCrop(
            @RequestBody CropRequest request,
            @RequestHeader("Authorization") String header
        ){
        CreateCropCommand cropCommand= cropMapper.requestDtoToCommand(request);
        CropResponse cropResponse=cropUseCase.registerCrop(cropCommand);
        log.info("Crop register : {}  Header : {}",cropResponse.getCropId(),header);

        return ResponseEntity.ok(ApiResponse.ok(cropResponse));
    }

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
        List<CropResponse> cropResponses=cropUseCase.fetchCrops(cropName);
        log.info("CropController : {} method : {} Header : {}",cropName,"fetchCrop",header);

        return ResponseEntity.ok(ApiResponse.ok(cropResponses));
    }
}
