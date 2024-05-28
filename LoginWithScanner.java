package mainFunctionalities;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;


public class LoginWithScanner
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
	  WebElement loginLink = driver.findElement(By.id("login2"));
      loginLink.click();

      // Create a Scanner object to get input from the user
      Scanner scanner = new Scanner(System.in);

      // Prompt the user to enter username and password
      System.out.print("Enter your username: ");
      String username = scanner.nextLine();

      System.out.print("Enter your password: ");
      String password = scanner.nextLine();

      // Find username and password fields and input values
      WebElement usernameField = driver.findElement(By.id("loginusername"));
      usernameField.sendKeys("Admin");

      WebElement passwordField = driver.findElement(By.id("loginpassword"));
      passwordField.sendKeys("Admin@123");
      
      WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
      signInButton.click();

  }
 

  @AfterTest
  public void afterTest()
  {
	  driver.close();
  }

}
