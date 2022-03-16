package TestDeamon.SeamlessHR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedIn {
	public WebDriver driver;

	By logOutBtn = By.cssSelector(".example a i");
	By verifyLoginText = By.cssSelector("#flash-messages #flash");
	
	
	public LoggedIn(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement verifyLogin() {
		return driver.findElement(verifyLoginText);
	}
	public Loginpage Logout() {
		driver.findElement(logOutBtn).click();
		return new Loginpage(driver);
	}
	
}
