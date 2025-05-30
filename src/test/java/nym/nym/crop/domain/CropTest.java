package nym.nym.crop.domain;

import nym.nym.crop.adapter.out.persistence.entity.CropCategory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CropTest {

    @Test
    void withoutId() {
        Crop crop=Crop.withoutId("test","crop", CropCategory.FOOD);

        assertThat(crop.getCropId()).isNull();
        assertThat(crop.getCropName()).isEqualTo("crop");
        assertThat(crop.getCropDescription()).isEqualTo("test");
        assertThat(crop.getCropCategory()).isEqualTo(CropCategory.FOOD);
    }

    @Test
    void withId() {
        Crop crop=Crop.withId(1L,"test","crop",CropCategory.FOOD);

        assertThat(crop.getCropId()).isEqualTo(1L);
        assertThat(crop.getCropName()).isEqualTo("crop");
        assertThat(crop.getCropCategory()).isEqualTo(CropCategory.FOOD);
        assertThat(crop.getCropDescription()).isEqualTo("test");
    }
}