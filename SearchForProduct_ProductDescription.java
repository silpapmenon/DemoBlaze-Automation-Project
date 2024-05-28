package mainFunctionalities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SearchForProduct_ProductDescription
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
	 
      
      // Navigate to the 'Laptops' category
      driver.findElement(By.linkText("Laptops")).click();

      // Select 'Sony vaio i5'
      driver.findElement(By.linkText("Sony vaio i5")).click();
  }
 
  @AfterTest
  public void afterTest()
  {
	  driver.close();
  }

}
