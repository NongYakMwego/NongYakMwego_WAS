
package nym.nym.data.adapter.out;

import lombok.extern.slf4j.Slf4j;
import nym.nym.domain.model.Crop;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
@Slf4j
public class ExcelCropReaderImpl implements ExcelCropReader{

    @Override
    public List<Crop> readCropsFromExcel(InputStream inputStream) {
        List<Crop> crops=new ArrayList<>();
        try {
            FileInputStream fileInputStream=new FileInputStream("./resources/init-data/cleaned_crop.xlsx");
            XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);

            //행의 수
            int rowIndex=0;
            //열의 수
            int columnIndex=0;

            XSSFSheet sheet=workbook.getSheetAt(0);
            int rows=sheet.getPhysicalNumberOfRows();
            for (rowIndex=0;rowIndex<rows;rowIndex++){
                //행 읽기
                XSSFRow row=sheet.getRow(rowIndex);
                if(row!=null){
                    //셀 수
                    int cells=row.getPhysicalNumberOfCells();
                    for (columnIndex=0;columnIndex<=cells;columnIndex++){
                        String cropName="";
                        String cropDetail="";
                        //셀 값 읽기
                        XSSFCell cell=row.getCell(columnIndex);
                        if(cell==null) continue;

                        //첫 번째열 -> 작물 이름과 매핑
                        if (columnIndex==0){
                            cropName=cell.getStringCellValue();
                        }else if(columnIndex==1){
                            cropDetail=cell.getStringCellValue();
                        }
                        //작물 리스트에 저장
                        crops.add(Crop.of(cropDetail,cropName));
                    }
                }
            }

        }catch (Exception e){
            log.error("ExcelCropReaderImpl  method : {} ","readCropsFromExcel");
        }
        log.info("ExcelCropReaderImpl  method : {} ","readCropsFromExcel");
        return crops;
    }
}
