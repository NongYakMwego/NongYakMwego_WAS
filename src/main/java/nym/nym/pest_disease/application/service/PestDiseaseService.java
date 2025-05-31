package nym.nym.pest_disease.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.global.common.annotaion.CustomLog;
import nym.nym.global.common.type.ErrorCode;
import nym.nym.global.exception.CustomException;
import nym.nym.pest_disease.adapter.in.web.PestDiseaseResponse;
import nym.nym.pest_disease.adapter.out.persistence.mapper.PestDiseaseMapper;
import nym.nym.pest_disease.application.port.in.FetchPestDiseaseUseCase;
import nym.nym.pest_disease.application.port.out.FetchPestDiseasePort;
import nym.nym.pest_disease.domain.PestDisease;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
     * @param cropId,name 작물 Id,병해충명
     * @return 병해충 응답 DTO
     */
    @Override
    @CustomLog
    public Page<PestDiseaseResponse> fetchPestDiseaseList(Long cropId ,String name,int page, int size) {
        //예외 name과 작물 Id 2개 모두 입력 시 에러 발생
        if(name!=null && cropId!=null){
            throw new CustomException(ErrorCode.NOT_FOUND_END_POINT);
        }
        //1. 페이징 객체 생성
        Pageable pageable=PageRequest.of(page,size);
        Page<PestDisease> pestDiseases=pestDiseasePort.fetchPestDiseases(cropId,name,pageable);

        return pestDiseases
                .map(pestDiseaseMapper::domainToResponseDto);

    }
}
