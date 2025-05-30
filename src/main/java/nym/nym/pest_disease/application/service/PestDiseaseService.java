package nym.nym.pest_disease.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.global.common.annotaion.CustomLog;
import nym.nym.pest_disease.adapter.in.web.PestDiseaseResponse;
import nym.nym.pest_disease.adapter.out.persistence.mapper.PestDiseaseMapper;
import nym.nym.pest_disease.application.port.in.FetchPestDiseaseUseCase;
import nym.nym.pest_disease.application.port.out.FetchPestDiseasePort;
import nym.nym.pest_disease.domain.PestDisease;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional(readOnly = true)
public class PestDiseaseService implements FetchPestDiseaseUseCase {
    private final FetchPestDiseasePort pestDiseasePort;
    private final PestDiseaseMapper pestDiseaseMapper;

    /**
     * @apiNote 병해충 다건 조회 메서드
     * @param cropId 작물 Id
     * @return 병해충 응답 DTO
     */
    @Override
    @CustomLog
    public List<PestDiseaseResponse> fetchPestDiseaseList(Long cropId) {
        List<PestDisease> pestDiseases=pestDiseasePort.fetchPestDiseases(cropId);

        return pestDiseases.stream()
                .map(pestDisease -> PestDiseaseResponse.builder()
                        .pestDiseaseId(pestDisease.getPestDiseaseId())
                        .pestDiseaseName(pestDisease.getPestDiseaseName())
                        .imageUrl(pestDisease.getImaUrl())
                        .build())
                .toList();
    }
}
