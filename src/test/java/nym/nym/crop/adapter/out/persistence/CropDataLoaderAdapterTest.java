package nym.nym.crop.adapter.out.persistence;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.TestPropertySource;
import org.springframework.test.util.ReflectionTestUtils;

import nym.nym.crop.adapter.out.persistence.entity.CropCategory;
import nym.nym.crop.application.port.out.CreateCropPort;
import nym.nym.crop.domain.Crop;
import nym.nym.data.application.port.out.ExcelDataReaderPort;

@ExtendWith(MockitoExtension.class)
@DisplayName("CropDataLoaderAdapter 테스트")
class CropDataLoaderAdapterTest {

    @Mock
    private CreateCropPort createCropPort;

    @Mock
    private ExcelDataReaderPort excelDataReaderPort;

    @InjectMocks
    private CropDataLoaderAdapter cropDataLoaderAdapter;

    private List<Map<String, String>> mockExcelData;

    @BeforeEach
    void setUp() {
        // @Value 필드 설정
        ReflectionTestUtils.setField(cropDataLoaderAdapter, "cropDataPath", "init-data/crop_final.xlsx");

        // 테스트용 엑셀 데이터 준비
        mockExcelData = createMockExcelData();
    }

    @Test
    @DisplayName("load - 작물 리스트를 받아서 각각을 생성한다")
    void load_SUCCESS() {
        // given
        List<Crop> crops = Arrays.asList(
                Crop.withoutId("빨간 토마토", "토마토", CropCategory.FRUIT),
                Crop.withoutId("주황색 당근", "당근", CropCategory.VEGETABLE)
        );

        // when
        cropDataLoaderAdapter.load(crops);

        // then
        verify(createCropPort, times(2)).createCrop(any(Crop.class));

        ArgumentCaptor<Crop> cropCaptor = ArgumentCaptor.forClass(Crop.class);
        verify(createCropPort, times(2)).createCrop(cropCaptor.capture());

        List<Crop> capturedCrops = cropCaptor.getAllValues();
        assertEquals("토마토", capturedCrops.get(0).getCropName());
        assertEquals("당근", capturedCrops.get(1).getCropName());
    }

    @Test
    @DisplayName("load - 빈 리스트를 전달하면 아무것도 생성하지 않는다")
    void load_EmptyList_DoesNothing() {
        // given
        List<Crop> emptyCrops = Arrays.asList();

        // when
        cropDataLoaderAdapter.load(emptyCrops);

        // then
        verify(createCropPort, never()).createCrop(any(Crop.class));
    }

    @Test
    @DisplayName("load - createCropPort에서 예외 발생 시 예외가 전파된다")
    void load_CreateCropPortThrowsException_ExceptionPropagated() {
        // given
        List<Crop> crops = Arrays.asList(
                Crop.withoutId("토마토 설명", "토마토", CropCategory.FRUIT)
        );
        doThrow(new RuntimeException("Database error"))
                .when(createCropPort).createCrop(any(Crop.class));

        // when & then
        assertThrows(RuntimeException.class, () -> cropDataLoaderAdapter.load(crops));
    }

    // 테스트용 엑셀 데이터 생성 헬퍼 메서드
    private List<Map<String, String>> createMockExcelData() {
        Map<String, String> row1 = new HashMap<>();
        row1.put("작물설명", "빨간 토마토");
        row1.put("작물명", "토마토");
        row1.put("카테고리", "과일"); // CropCategory.fromMsg()에 맞는 값

        Map<String, String> row2 = new HashMap<>();
        row2.put("작물설명", "주황색 당근");
        row2.put("작물명", "당근");
        row2.put("카테고리", "채소"); // CropCategory.fromMsg()에 맞는 값

        return Arrays.asList(row1, row2);
    }
}