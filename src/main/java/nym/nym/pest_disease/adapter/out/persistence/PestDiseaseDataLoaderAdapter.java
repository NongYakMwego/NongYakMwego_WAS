package nym.nym.pest_disease.adapter.out.persistence;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.data.application.port.out.DataLoaderPort;
import nym.nym.data.application.port.out.ExcelDataReaderPort;
import nym.nym.global.common.annotaion.CustomLog;
import nym.nym.global.common.annotaion.PersistenceAdapter;
import nym.nym.pest_disease.application.port.out.CreatePestDiseasePort;
import nym.nym.pest_disease.domain.PestDisease;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@PersistenceAdapter("pestDiseaseDataLoaderAdapter")
public class PestDiseaseDataLoaderAdapter implements DataLoaderPort<PestDisease> {
    private final CreatePestDiseasePort createPestDiseasePort;
    private final ExcelDataReaderPort excelDataReaderPort;

    @Value("init-data/combined_result.xlsx")
    private String pestDiseaseDataPath;

    @PostConstruct
    @CustomLog
    public void loadData(){
        try(InputStream inputStream=getClass().getClassLoader().getResourceAsStream(pestDiseaseDataPath)) {
            List<Map<String,String>> rawData=excelDataReaderPort.read(inputStream);
            List<PestDisease> pestDiseases=rawData.stream()
                    .map(row->PestDisease.withoutId(
                            row.get("pest-diseaseNameKor"),
                            row.get("pest-diseaseNameEng"),
                            row.get("img")
                    )).toList();
            load(pestDiseases);

        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    @CustomLog
    public void load(List<PestDisease> data) {
        data.forEach(createPestDiseasePort::createPestDisease);
    }
}
