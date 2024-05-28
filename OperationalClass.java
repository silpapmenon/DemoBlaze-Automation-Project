package keywordDrivenFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OperationalClass
{
	private WebDriver driver;

    public void openBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
        	System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Documents\\Automation Testing\\BrowserExtention\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        // Add other browsers if needed
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public void click(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void type(String locator, String data) {
        driver.findElement(By.xpath(locator)).sendKeys(data);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}

