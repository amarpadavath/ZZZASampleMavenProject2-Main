package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class JavaScriptUtils {
	
	private WebDriver driver;
	
	public JavaScriptUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickElementUsingJS(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].click();", element);
	}
	
/*	public void ScrollIntoView(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", element);)
		
	}
	
	 public String getPageTitleUsingJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return document.title;");
    }
	*/
	
	

}
