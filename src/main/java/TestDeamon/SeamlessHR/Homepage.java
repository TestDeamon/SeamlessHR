package TestDeamon.SeamlessHR;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
	public WebDriver driver;
	
	By formAuth = By.cssSelector("#content ul li:nth-child(21) a");
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void scrollToFormAuth() {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("window.scrollBy(0,200)");
	}
	
	public WebElement getFormAuth() {
		return driver.findElement(formAuth);
	}
	
	public Loginpage clickFormAuth() {
		getFormAuth().click();
		return new Loginpage(driver);
	}
	
}
