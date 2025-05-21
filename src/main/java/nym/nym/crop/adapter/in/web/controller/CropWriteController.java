package nym.nym.crop.adapter.in.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.crop.adapter.in.web.CropRequest;
import nym.nym.crop.adapter.in.web.CropResponse;
import nym.nym.crop.application.port.in.CreateCropCommand;
import nym.nym.crop.application.port.in.CreateCropUseCase;
import nym.nym.global.common.dto.ApiResponse;
import nym.nym.crop.adapter.out.persistence.mapper.CropMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crop")
@Slf4j
public class CropWriteController {
    private final CreateCropUseCase cropUseCase;
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

}
