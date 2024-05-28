package mainFunctionalities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class CheckOut
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
      
      // Wait for the cart popup to appear
      WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartur")));

      // Click on the Cart button
      WebElement cartButton = driver.findElement(By.id("cartur"));
      cartButton.click();

      // Click on the Place Order button
      WebElement placeOrderButton = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button"));
      placeOrderButton.click();

      // Fill in the order details
      WebElement nameInput = driver.findElement(By.id("name"));
      nameInput.sendKeys("John Doe");

      WebElement countryInput = driver.findElement(By.id("country"));
      countryInput.sendKeys("USA");

      WebElement cityInput = driver.findElement(By.id("city"));
      cityInput.sendKeys("New York");

      WebElement creditCardInput = driver.findElement(By.id("card"));
      creditCardInput.sendKeys("1234567890");

      WebElement monthInput = driver.findElement(By.id("month"));
      monthInput.sendKeys("12");

      WebElement yearInput = driver.findElement(By.id("year"));
      yearInput.sendKeys("2025");

      // Click on the Purchase button
      WebElement purchaseButton = driver.findElement(By.xpath("//button[text()='Purchase']"));
      purchaseButton.click();

      
      // Click on OK button
      WebElement okButton = driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button"));
  }
  private void scrollToElement(WebDriver driver, WebElement element) {
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
  }

  
 

  @AfterTest
  public void afterTest()
  {
	  driver.close();
  }

}
