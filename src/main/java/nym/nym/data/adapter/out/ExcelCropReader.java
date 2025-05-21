package nym.nym.data.adapter.out;

import nym.nym.crop.domain.Crop;

import java.io.InputStream;
import java.util.List;

public interface ExcelCropReader {
    List<Crop> readCropsFromExcel(InputStream inputStream);
}
