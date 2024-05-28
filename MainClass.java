package keywordDrivenFramework;

import org.apache.hc.client5.http.impl.Operations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



@Test
public class MainClass
{private OperationalClass operations;
private static final String EXCEL_PATH = "C:\\Users\\HP\\Documents\\Automation Testing\\POI\\DEMOBLAZE.xlsx";
private static final String SHEET_NAME = "KDT";

@BeforeClass
public void setUp() {
    operations = new OperationalClass();
}

@Test(dataProvider = "getData")
public void testKeywords(String keyword, String locator, String data) {
    switch (keyword) {
        case "openBrowser":
            operations.openBrowser(data);
            break;
        case "navigate":
            operations.navigate(data);
            break;
        case "click":
            operations.click(locator);
            break;
        case "type":
            operations.type(locator, data);
            break;
        case "closeBrowser":
            operations.closeBrowser();
            break;
        default:
            System.out.println("Invalid keyword");
            break;
    }
}

@DataProvider
public Object[][] getData() {
    ReadExcelClass readExcel = new ReadExcelClass();
    String[][] excelData = readExcel.getExcelData(EXCEL_PATH, SHEET_NAME);
    
    if (excelData == null) {
        throw new RuntimeException("Failed to read data from Excel file: " + EXCEL_PATH);
    }

    Object[][] testData = new Object[excelData.length][3];
    for (int i = 0; i < excelData.length; i++) {
        testData[i][0] = excelData[i][0]; // keyword
        testData[i][1] = excelData[i][1]; // locator
        testData[i][2] = excelData[i][2]; // data
    }
    return testData;
}

@AfterClass
public void tearDown() {
    if (operations.getDriver() != null) {
        operations.closeBrowser();
    }
}
}