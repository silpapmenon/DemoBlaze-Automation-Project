package mainFunctionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignIn 
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
	  WebElement signupLink = driver.findElement(By.id("signin2"));
      signupLink.click(); 
	  driver.findElement(By.xpath("//*[@id=\"sign-username\"]")).sendKeys("Admin");
	  driver.findElement(By.xpath("//*[@id=\"sign-password\"]")).sendKeys("Admin@123");
	  driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]"));
	  
  }
 

  @AfterTest
  public void afterTest()
  {
	  driver.close();
  }

}
