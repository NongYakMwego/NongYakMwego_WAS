package nym.nym.data.application.port.out;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface ExcelDataReaderPort {
    List<Map<String,String>> read(InputStream inputStream);
}
