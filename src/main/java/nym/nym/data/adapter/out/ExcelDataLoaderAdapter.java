package nym.nym.data.adapter.out;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.data.application.port.out.ExcelDataReaderPort;
import nym.nym.global.common.annotaion.CustomLog;
import nym.nym.global.common.annotaion.PersistenceAdapter;
import org.apache.poi.ss.usermodel.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@PersistenceAdapter("excelDataLoaderAdapter")
@Slf4j
public class ExcelDataLoaderAdapter implements ExcelDataReaderPort {

    @Override
    @CustomLog
    public List<Map<String, String>> read(InputStream inputStream) {
        List<Map<String,String>> data=new ArrayList<>();
        try (Workbook workbook= WorkbookFactory.create(inputStream)){
            Sheet sheet=workbook.getSheetAt(0);

            Row headerRow=sheet.getRow(0);
            List<String> headers=new ArrayList<>();
            for (Cell cell:headerRow){
                headers.add(cell.getStringCellValue());
            }


            // 데이터 읽기
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row dataRow = sheet.getRow(i);
                if (dataRow != null) {
                    Map<String, String> rowData = new HashMap<>();
                    for (int j = 0; j < headers.size(); j++) {
                        Cell cell = dataRow.getCell(j);
                        String value = "";
                        if (cell != null) {
                            switch (cell.getCellType()) {
                                case STRING:
                                    value = cell.getStringCellValue();
                                    break;
                                case NUMERIC:
                                    if (DateUtil.isCellDateFormatted(cell)) {
                                        value = cell.getDateCellValue().toString();
                                    } else {
                                        value = String.valueOf(cell.getNumericCellValue());
                                    }
                                    break;
                                case BOOLEAN:
                                    value = String.valueOf(cell.getBooleanCellValue());
                                    break;
                                case FORMULA:
                                    value = cell.getCellFormula();
                                    break;
                                default:
                                    break;
                            }
                        }
                        rowData.put(headers.get(j), value);
                    }
                    data.add(rowData);
                }
            }
        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
        return data;
    }
}
