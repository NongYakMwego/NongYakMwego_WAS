package nym.nym.pest_disease.adapter.in.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.global.common.annotaion.CustomLog;
import nym.nym.global.common.dto.ApiResponse;
import nym.nym.pest_disease.adapter.in.web.PestDiseaseResponse;
import nym.nym.pest_disease.application.port.in.FetchPestDiseaseUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pest-disease")
@Slf4j
public class PestDiseaseQueryController {
    private final FetchPestDiseaseUseCase fetchPestDiseaseUseCase;


    @GetMapping("/fetch-list")
    @CustomLog
    public ResponseEntity<ApiResponse<List<PestDiseaseResponse>>> fetchPestDiseases(
            @RequestParam(value = "cropId") Long cropId
    ){
        List<PestDiseaseResponse> pestDiseaseResponses=fetchPestDiseaseUseCase.fetchPestDiseaseList(cropId);
        return ResponseEntity.ok(ApiResponse.ok(pestDiseaseResponses));
    }
}
