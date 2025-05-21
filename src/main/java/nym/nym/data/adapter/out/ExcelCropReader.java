package nym.nym.data.adapter.out;

import nym.nym.domain.model.Crop;

import java.io.InputStream;
import java.util.List;

public interface ExcelCropReader {
    List<Crop> readCropsFromExcel(InputStream inputStream);
}
