package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitUtil;

public class DemoQATextBoxPage {

	private WebDriver driver;

	private WaitUtil waitUntil;

	private JavascriptExecutor js;

	public DemoQATextBoxPage(WebDriver driver) {
		this.driver = driver;

		this.waitUntil = new WaitUtil(driver);

		this.js = (JavascriptExecutor) driver;
	}

	private By textBoxAccordion = By.xpath("//span[@class='text' and text()='Text Box']");

	private By fullName = By.xpath("//input[@placeholder='Full Name']");
	private By emailAddress = By.xpath("//input[@placeholder='name@example.com']");
	private By currentAddress = By.xpath("//textarea[@placeholder='Current Address']");
	private By permanantAddress = By.xpath("//textarea[@id='permanentAddress']");
	private By submit = By.xpath("//button[@id='submit']");

	public void clickOntextBoxAccordion() {
		WebElement textBoxAccordionMethod = waitUntil.waitForElementToBeClickable(textBoxAccordion);
		textBoxAccordionMethod.click();
		// waitUntil.waitForElementToBeClickable(textBoxAccordion).click()
	}

	public void inputFullName(String name)

	{
		WebElement fullName1 = waitUntil.waitForElementToBeClickable(fullName);

		fullName1.sendKeys(name);

	}

	public void inputEmailAddress(String address)

	{
		WebElement emailAddress1 = waitUntil.waitForElementToBeClickable(emailAddress);

		emailAddress1.sendKeys(address);

	}

	public void inputCurrentAdd(String parameter)

	{
		WebElement currentAddress1 = waitUntil.waitForElementToBeClickable(currentAddress);

		currentAddress1.sendKeys(parameter);

	}

	public void inputPermenantAdd(String parameter)

	{
		WebElement permanantAddress1 = waitUntil.waitForElementToBeClickable(permanantAddress);

		permanantAddress1.sendKeys(parameter);

	}

	public void clickSubmit() {
		WebElement submit1 = waitUntil.waitForElementToBeClickable(submit);
		submit1.click();
	}
	

	public void clickOnSubmitElementsJS() {
		// TODO Auto-generated method stub
		WebElement clickSubmit =  waitUntil.waitForElementToBeClickable(submit);
		
		  js.executeScript("arguments[0].click();", clickSubmit);
		
	}

}
