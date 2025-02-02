package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitUtil;

public class DemoQAHomePage {
	
	private WebDriver driver;
	
	private WaitUtil waitUntil;
	
	 private JavascriptExecutor js;
	
	public DemoQAHomePage(WebDriver driver)
	{
		this.driver = driver;
		this.waitUntil= new WaitUtil(driver);
		 this.js = (JavascriptExecutor) driver;
	}
	
	private By elements = By.xpath("//h5[text()='Elements']/parent::div");
	
	public void clickOnElements()
	{
		WebElement clickElement =  waitUntil.waitForElementToBeClickable(elements);
		clickElement.click();
	}
	
	public void clickOnElementsJS()
	{
		WebElement clickElement =  waitUntil.waitForElementToBeClickable(elements);
		
		  js.executeScript("arguments[0].click();", clickElement);
	}

}
