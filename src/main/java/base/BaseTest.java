package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected static  WebDriver driver;
	
	public void initialiseDriver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();		
			}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
			
		}
		
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
	}
	
	
}
