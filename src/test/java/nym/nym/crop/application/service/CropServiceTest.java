package nym.nym.crop.application.service;

import nym.nym.crop.adapter.in.web.CropResponse;
import nym.nym.crop.adapter.out.persistence.entity.CropCategory;
import nym.nym.crop.adapter.out.persistence.mapper.CropMapper;
import nym.nym.crop.application.port.out.FetchCropPort;
import nym.nym.crop.domain.Crop;
import nym.nym.crop.domain.CropInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CropServiceTest {
    @InjectMocks
    private CropService cropService;

    @Mock
    private FetchCropPort fetchCropPort;

    @Mock
    private CropMapper cropMapper;

    @Test
    @DisplayName("작물 리스트 조회 성공 시 CropResponse 리스트 반환한다.")
    void fetchCropByList_SUCCESS(){
        //given
        String findKeyword="감자";
        List<CropInfo> cropInfos=List.of(
                CropInfo.of(1L,"감자1"),
                CropInfo.of(2L,"감자2"),
                CropInfo.of(3L,"감자3")
        );

        List<CropResponse> expected=List.of(
                CropResponse.builder().cropId(1L).cropName("감자1").build(),
                CropResponse.builder().cropId(2L).cropName("감자2").build(),
                CropResponse.builder().cropId(3L).cropName("감자3").build()
        );

        //when
        when(fetchCropPort.fetchCrops(findKeyword)).thenReturn(cropInfos);
        List<CropResponse> result=cropService.fetchCropByList(findKeyword);

        //then
        assertEquals(3,result.size());
        assertEquals(result.get(0).getCropName(),expected.get(0).getCropName());
        assertEquals(result.get(1).getCropName(),expected.get(1).getCropName());
        assertEquals(result.get(2).getCropName(),expected.get(2).getCropName());
    }

    @Test
    @DisplayName("작물 단건 조회 성공 시 CropResponse 리스트 반환한다.")
    void fetchSingleCrop_SUCCESS(){
        //given
        Long findId=1L;
        Crop crop= Crop.withId(findId,"설명","감자", CropCategory.FOOD);

        CropResponse expected= CropResponse.builder()
                                .cropId(1L)
                                .cropName("감자")
                                .cropDescription("설명")
                                .build();

        //when
        when(fetchCropPort.fetchCrop(findId)).thenReturn(crop);
        when(cropMapper.domainToResponseDto(crop)).thenReturn(expected);
        CropResponse result=cropService.fetchSingleCrop(findId);

        //then
        assertEquals(expected.getCropName(),result.getCropName());
        assertEquals(expected.getCropDescription(),result.getCropDescription());

    }
}