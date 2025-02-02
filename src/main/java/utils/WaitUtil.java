package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	public WaitUtil(WebDriver driver)
	{
		this.driver=driver;
		
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public WebElement waitForVisibility(By locator)
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public WebElement waitForElementToBeClickable(By locator)
	{
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public WebElement waitForPrsesence(By locator)
	{
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public WebElement fluentWaitForElement(By locator)
	{
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
