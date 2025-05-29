package nym.nym.crop.adapter.in.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import nym.nym.crop.adapter.in.web.CropResponse;
import nym.nym.crop.adapter.out.persistence.entity.CropCategory;
import nym.nym.crop.application.port.in.FetchCropUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class CropQueryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private FetchCropUseCase fetchCropUseCase;

    @Test
    @DisplayName("작물 다건 조회 API")
    void fetchCrops() throws Exception {
        //given
        String cropName="감자";
        List<CropResponse> expected = expectedCropList();
        given(fetchCropUseCase.fetchCropByList(cropName)).willReturn(expected);

        //when
        //then
        mockMvc.perform(get("/crop/fetch-list")
                .param("cropName",cropName)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.length()").value(3))
                .andExpect(jsonPath("$.data[0].cropName").value("감자11"))
                .andExpect(jsonPath("$.data[1].cropName").value("감자12"))
                .andExpect(jsonPath("$.data[2].cropName").value("감자13"));

    }

    @Test
    void fetchCrop() throws Exception {
        //given
        Long cropId=1L;
        CropResponse expected=expectedCropList().get(0);
        given(fetchCropUseCase.fetchSingleCrop(cropId)).willReturn(expected);

        //when
        //then
        mockMvc.perform(get("/crop/fetch-single")
                .param("cropId",String.valueOf(cropId))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.cropName").value("감자11"))
                .andExpect(jsonPath("$.data.cropDescription").value("설명1"))
                .andExpect(jsonPath("$.data.category").value(CropCategory.FRUIT.getMsg()));
    }

    private static List<CropResponse> expectedCropList(){
        return List.of(
                CropResponse.builder().cropId(1L).cropName("감자11").cropDescription("설명1").category(CropCategory.FRUIT.getMsg()).build(),
                CropResponse.builder().cropId(2L).cropName("감자12").cropDescription("설명2").category(CropCategory.FRUIT.getMsg()).build(),
                CropResponse.builder().cropId(3L).cropName("감자13").cropDescription("설명3").category(CropCategory.FRUIT.getMsg()).build()
        );
    }
}