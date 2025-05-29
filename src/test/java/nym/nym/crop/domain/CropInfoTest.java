package nym.nym.crop.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CropInfoTest {
    @Test
    void of(){
        CropInfo cropInfo=CropInfo.of(1L,"crop");

        assertThat(cropInfo.getCropId()).isEqualTo(1L);
        assertThat(cropInfo.getCropName()).isEqualTo("crop");
    }

}