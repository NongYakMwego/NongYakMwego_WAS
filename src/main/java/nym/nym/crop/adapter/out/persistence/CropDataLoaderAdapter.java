package nym.nym.crop.adapter.out.persistence;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.crop.application.port.out.CreateCropPort;
import nym.nym.crop.domain.Crop;
import nym.nym.data.application.port.out.DataLoaderPort;
import nym.nym.data.application.port.out.ExcelDataReaderPort;
import nym.nym.global.common.annotaion.CustomLog;
import nym.nym.global.common.annotaion.PersistenceAdapter;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@PersistenceAdapter("cropDataLoaderAdapter")
public class CropDataLoaderAdapter implements DataLoaderPort<Crop> {
    private final CreateCropPort createCropPort;
    private final ExcelDataReaderPort excelDataReaderPort;

    //엑셀 파일 경로
    @Value("init-data/crop_final.xlsx")
    private String cropDataPath;

    @PostConstruct
    @CustomLog
    public void loadData() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(cropDataPath)) {
            List<Map<String, String>> rawData = excelDataReaderPort.read(inputStream);
            List<Crop> crops = rawData.stream()
                    .map(row -> Crop.withoutId(
                            row.get("서브내용1"),
                            row.get("제목")
                    )).toList();
            load(crops);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @CustomLog
    public void load(List<Crop> data) {
        data.forEach(createCropPort::createCrop);
    }
}
