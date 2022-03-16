package TestDeamon.SeamlessHR;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.Base;

public class HomepageTest extends Base{
	public WebDriver driver;
	Homepage hp;
	Loginpage lp; 
	LoggedIn lgd;
	
//	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException{
		 driver = initializeDriver();
		 driver.manage().window().maximize();
	}

	@Test(dataProvider="getData")
	public void verifyLogin(String username, String password, String message) throws IOException, InterruptedException{
		driver.get(prop.getProperty("url"));
		hp = new Homepage(driver);
		hp.scrollToFormAuth();
		Thread.sleep(2000);
		Assert.assertTrue(hp.getFormAuth().isDisplayed());
		
		lp = hp.clickFormAuth();
		
		Thread.sleep(3000);
		System.out.println(username);
		System.out.println(password);
		System.out.println(message);
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		
		lgd = lp.clickLoginBtn();
		
		Thread.sleep(3000);
		
		String[] loginText = lgd.verifyLogin().getText().split("\\n");

		
		Assert.assertEquals(loginText[0].trim(), message);
		
		Thread.sleep(3000);
		lp = lgd.Logout();
		
	}
	
	
	

	@AfterTest
	public void teardown(){
		driver.quit();
	}

	
	
	@DataProvider
	public Object[][] getData(){
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[2][3];
		//0th row
		data[0][0]="tomsmith";
		data[0][1]="SuperSecretPassword!";
		data[0][2]="You logged into a secure area!";
		//1st row
		data[1][0]="thomas";
		data[1][1]="SecretPassword!";
		data[1][2]="Your username is invalid!";
		
		return data;
	}
}
