package nym.nym.crop.adapter.out.persistence.mapper;

import nym.nym.crop.adapter.in.web.CropResponse;
import nym.nym.crop.adapter.out.persistence.entity.CropCategory;
import nym.nym.crop.adapter.out.persistence.entity.CropDetail;
import nym.nym.crop.adapter.out.persistence.entity.CropEntity;
import nym.nym.crop.domain.Crop;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CropMapperImplTest {

    @Autowired
    private CropMapperImpl cropMapper;
    @Test
    @DisplayName("도메인을 엔티티 형태로 매핑한다.")
    void domainToEntity() {
        //given
        Crop crop=Crop.withoutId("설명","감자", CropCategory.FOOD);

        //when
        CropEntity expected=cropMapper.domainToEntity(crop);


        //then
        assertThat(expected).isNotNull();
        assertThat(expected.getCropCategory()).isEqualTo(CropCategory.FOOD);

        CropDetail cropDetail=expected.getCropDetail();
        assertThat(cropDetail.getCropName()).isEqualTo("감자");
        assertThat(cropDetail.getCropDescription()).isEqualTo("설명");
    }

    @Test
    @DisplayName("엔티티를 도메인으로 매핑한다.")
    void entityToDomain() {
        //given
        CropEntity cropEntity=CropEntity
                .builder()
                .cropCategory(CropCategory.FOOD)
                .cropDetail(new CropDetail("설명","감자"))
                .build();

        //when
        Crop expected=cropMapper.entityToDomain(cropEntity);

        //then
        assertThat(expected).isNotNull();
        assertThat(expected.getCropCategory()).isEqualTo(CropCategory.FOOD);
        assertThat(expected.getCropName()).isEqualTo("감자");
        assertThat(expected.getCropDescription()).isEqualTo("설명");
    }

    @DisplayName("도메인을 응답Dto로 매핑한다.")
    @Test
    void domainToResponseDto() {
        //given
        Crop crop=Crop.withId(1L,"설명","감자",CropCategory.FOOD);

        //when
        CropResponse expected=CropResponse
                .builder()
                .cropId(1L)
                .cropName("감자")
                .cropDescription("설명")
                .category("식량작물")
                .build();

        //then
        assertThat(expected).isNotNull();
        assertThat(expected.getCategory()).isEqualTo(CropCategory.FOOD.getMsg());
        assertThat(expected.getCropName()).isEqualTo("감자");
        assertThat(expected.getCropDescription()).isEqualTo("설명");
    }
}