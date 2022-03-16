package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public  WebDriver driver;
	public Properties prop;
	
	
	public WebDriver initializeDriver() throws IOException{	
		prop = new Properties();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		FileInputStream fis = new FileInputStream("C:\\Users\\David Alola\\eclipse-workenvironment\\SeamlessHR\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\David Alola\\eclipse-workenvironment\\Chrome\\src\\main\\java\\resources\\chromedriver.exe");
			 driver = new ChromeDriver(chromeOptions);
//			 driver = new ChromeDriver();
			 
		}
		else if (browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\David Alola\\Downloads\\Compressed\\geckodriver-v0.30.0-win64_2\\geckodriver.exe");
			 driver= new FirefoxDriver();
		}
		else{
			driver = new InternetExplorerDriver();
		}
		
		return driver;
	}


}
