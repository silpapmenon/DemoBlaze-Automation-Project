package mainFunctionalities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginWithJOptionPane
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
   // Prompt the user to enter username and password using JOptionPane
      String username = JOptionPane.showInputDialog("Enter your username:");
      String password = JOptionPane.showInputDialog("Enter your password:");

      // Find username and password fields and input values
      WebElement usernameField = driver.findElement(By.id("loginusername"));
      usernameField.sendKeys("SilpaPMenon");
      
      WebElement passwordField = driver.findElement(By.id("loginpassword"));
      passwordField.sendKeys("Silpa@123");

      // Find and click on the login button
      WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
      signInButton.click();

  }
  

  @AfterTest
  public void afterTest()
  {
	  driver.close();
  }

}
