package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitUtil;

public class MagentoAccountPage {
	
private WebDriver driver ;
	
	private WaitUtil waitUntil;
	
	private By successText = By.xpath("//div[text()='Thank you for registering with Main Website Store.']");
	
	private By nameText = By.xpath("//div[@class='box-content']/child::p");
	
	private By emailText = By.xpath("(//div[@class='box-content']/child::p/child::br)[1]");
	
	public MagentoAccountPage(WebDriver  driver)
	{
		this.driver = driver;
		this.waitUntil= new WaitUtil(driver);
	}
	
	public String getSuccessText()

	{
		
		WebElement getSuccessText = waitUntil.waitForVisibility(successText);
		return getSuccessText.getText();
	}
	
	public String getNameText()

	{

		WebElement nameText1 = waitUntil.waitForVisibility(nameText);
		return nameText1.getText();
		
	}
	
	public String getEmailText()

	{

		WebElement getEmailText1 = waitUntil.waitForVisibility(emailText);
		return getEmailText1.getText();
		
	}

}
