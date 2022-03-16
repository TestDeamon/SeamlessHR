package TestDeamon.SeamlessHR;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {
	public WebDriver driver;
	
	By loginText = By.cssSelector(".example h2");
	By username = By.id("username"); 
	By pwd = By.id("password");
	By loginBtn = By.cssSelector("button[type='submit']");

	By logOutBtn = By.cssSelector(".example a i");
	
	
	public Loginpage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getLoginText() {
		return driver.findElement(loginText);
	}
	public WebElement getUsername() {
		return driver.findElement(username);
	}
	public WebElement getPassword() {
		return driver.findElement(pwd);
	}
	public LoggedIn clickLoginBtn() {
		driver.findElement(loginBtn).click();
		return new LoggedIn(driver);
	}


}
