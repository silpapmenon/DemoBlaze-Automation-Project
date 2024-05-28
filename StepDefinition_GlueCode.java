package bddFramework_CucumberTool;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition_GlueCode
{
	WebDriver driver;
	@Given("I am on the Demoblaze homepage")
	public void i_am_on_the_demoblaze_homepage()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Documents\\Automation Testing\\BrowserExtention\\chromedriver.exe");
	     driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.get("https://www.demoblaze.com/index.html");
	    
	}

	@When("I click on the {string} category")
	public void i_click_on_the_category(String string)
	{
		 WebElement laptopsCategory = driver.findElement(By.xpath("//a[text()='Laptops']"));
	      laptopsCategory.click();
	    
	}

	@When("I click on the {string} product")
	public void i_click_on_the_product(String string) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	      WebElement sonyVaioProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")));
	      sonyVaioProduct.click();
	    
	}

	@When("I click on the {string} button")
	public void i_click_on_the_button(String string) {
		 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	      WebElement addToCartButton = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
	      addToCartButton.click();
	    
	}

	@Then("I should see the {string} alert")
	public void i_should_see_the_alert(String expectedAlert) 
	{
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        String actualAlert = wait.until(ExpectedConditions.alertIsPresent()).getText();
        assertEquals(expectedAlert, actualAlert);
        driver.switchTo().alert().accept();
	    
	}

	

	@Then("I should see the {string} page")
	public void i_should_see_the_product_cart_page(String string)
	{
		WebElement cartButton = driver.findElement(By.id("cartur"));
	      cartButton.click();
	   
	}
	

	@Then("I close the browser")
	public void i_close_the_browser()
	{
	   driver.close();;
	    
	}






}
