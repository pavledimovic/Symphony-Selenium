package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;


public class ReadExcelConfig {
    XSSFWorkbook wb;
    XSSFSheet sheet1;

    public ReadExcelConfig(String excelpath) {
        try {
            File src = new File(excelpath);
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getData(int sheetNumber, int row, int column) {
        sheet1 = wb.getSheetAt(sheetNumber);
        String data = sheet1.getRow(row).getCell(column).getStringCellValue();
        return data;
    }

    public int getRowCount(int SheetIndex) {
        int row = wb.getSheetAt(SheetIndex).getLastRowNum();
        row = row + 1;
        return row;
    }

}
