package keywordDrivenFramework;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ReadExcelClass
{
	public String[][] getExcelData(String fileName, String sheetName) {
        String[][] data = null;
        FileInputStream fis = null;
        XSSFWorkbook workbook = null;
        
        try {
            fis = new FileInputStream(fileName);
            workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new String[rowCount - 1][colCount];

            DataFormatter formatter = new DataFormatter();
            for (int i = 1; i < rowCount; i++) {
                XSSFRow row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    data[i - 1][j] = formatter.formatCellValue(row.getCell(j));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return data;
    }
}

