package nym.nym.crop.adapter.out.persistence;

import nym.nym.crop.adapter.out.persistence.entity.CropCategory;
import nym.nym.crop.adapter.out.persistence.entity.CropEntity;
import nym.nym.crop.adapter.out.persistence.mapper.CropMapperImpl;
import nym.nym.crop.domain.Crop;
import nym.nym.crop.domain.CropInfo;
import nym.nym.global.common.type.ErrorCode;
import nym.nym.global.exception.CustomException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Import({CropPersistenceAdapter.class, CropMapperImpl.class})
@ActiveProfiles("test")
@SqlGroup({
        @Sql(value = "/sql/crop-persistence-adapter.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
})
class CropPersistenceAdapterTest {
    @Autowired
    private CropPersistenceAdapter cropPersistenceAdapter;

    @Autowired
    private CropRepository cropRepository;

    @Test
    @DisplayName("작물이름으로 작물을 일괄조회한다(이름-오름차순)")
    public void fetchCrops_SUCCESS(){
        //given
        String cropName="a";

        //when
        List<CropInfo> cropInfos=cropPersistenceAdapter.fetchCrops(cropName);

        //then
        assertThat(cropInfos).isNotEmpty();
        assertThat(cropInfos).hasSize(10);

        for (int i=0;i<cropInfos.size();i++){
            StringBuilder str= new StringBuilder();
            for (int j=0;j<=i;j++){
                str.append("a");
            }
            assertThat(cropInfos.get(i).getCropName()).isEqualTo(str.toString());
            assertThat(cropInfos.get(i).getCropId()).isEqualTo(i+1);
        }
    }

    @Test
    @DisplayName("작물이름으로 작물을 일괄조회 시 일치하는 작물이 없으면 빈 배열을 반환한다.")
    public void fetchCrops_FAIL(){
        //given
        String cropName="b";

        //when
        List<CropInfo> cropInfos=cropPersistenceAdapter.fetchCrops(cropName);

        //then
        assertThat(cropInfos).isEmpty();
        assertThat(cropInfos).isEqualTo(new ArrayList<>());
    }

    @Test
    @DisplayName("작물Id로 작물을 단건 조회한다.")
    public void fetchCrop_SUCCESS(){
        //given
        Long findId=1L;

        //when
        Crop findCrop=cropPersistenceAdapter.fetchCrop(findId);

        //then
        assertThat(findCrop).isNotNull();
        assertThat(findCrop.getCropDescription()).isEqualTo("설명1");
        assertThat(findCrop.getCropCategory()).isEqualTo(CropCategory.FOOD);
        assertThat(findCrop.getCropName()).isEqualTo("a");
        assertThat(findCrop.getCropId()).isEqualTo(1L);
    }

    @Test
    @DisplayName("작물Id로 작물을 단건 조회시 존재하지 않으면 CustomException 예외를 반환한다.")
    public void fetchCrop_FAIL(){
        //given
        Long findId=99999L;

        //when
        CustomException exception=org.junit.jupiter.api.Assertions.assertThrows(CustomException.class,
                ()->cropPersistenceAdapter.fetchCrop(findId)
        );

        //then
        assertThat(exception.getErrorCode()).isEqualTo(ErrorCode.NOT_EXIST_CROP_ID);
    }

    @Test
    @DisplayName("작물 도메인을 생성한다.")
    public void createCrop_SUCCESS(){
        //given
        Crop crop=Crop.withoutId("설명","고추",CropCategory.FOOD);

        //when
        Crop savedCrop=cropPersistenceAdapter.createCrop(crop);

        //then
        assertNotNull(savedCrop);
        assertNotNull(savedCrop.getCropId());
        assertEquals(savedCrop.getCropName(),crop.getCropName());
        assertEquals(savedCrop.getCropDescription(),crop.getCropDescription());
        assertEquals(savedCrop.getCropCategory(),crop.getCropCategory());

        Optional<CropEntity> foundEntity=cropRepository.findById(savedCrop.getCropId());
        assertTrue(foundEntity.isPresent());
    }

}