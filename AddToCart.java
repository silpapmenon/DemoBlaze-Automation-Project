package mainFunctionalities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class AddToCart
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
	 
	// Select a category (e.g., Laptops)
      WebElement laptopsCategory = driver.findElement(By.xpath("//a[text()='Laptops']"));
      laptopsCategory.click();

      // Select a product (e.g., Sony vaio i5)
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement sonyVaioProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")));
      sonyVaioProduct.click();

      // Add the product to the cart
      WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
      addToCartButton.click();
  }
 

  @AfterTest
  public void afterTest()
  {
	  driver.close();
  }

}
