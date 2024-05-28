package mainFunctionalities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AboutApplication
{
	WebDriver driver;
	 @BeforeTest
	  public void beforeTest() 
	 {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Documents\\Automation Testing\\BrowserExtention\\chromedriver.exe");
	     driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
	  }

  @Test
  public void Test()
  {
	  driver.get("https://www.demoblaze.com/index.html");
	  driver.manage().window().maximize();
	  WebElement aboutUsLink = driver.findElement(By.xpath("//a[contains(text(),'About us')]"));
      aboutUsLink.click();

      // Optionally perform actions/assertions on the About Us page
      // For example, you can verify the page title
      String pageTitle = driver.getTitle();
      System.out.println("Page Title: " + pageTitle);
  }
 
  @AfterTest
  public void afterTest()
  {
	  driver.close();
  }

}
