package dataDrivenFremework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageClass 
{
	WebDriver driver;

    public void HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By loginLink = By.id("login2");

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }
}
