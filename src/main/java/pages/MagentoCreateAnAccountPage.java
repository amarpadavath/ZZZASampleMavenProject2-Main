package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.EmailGeneratorUtil;
import utils.WaitUtil;

public class MagentoCreateAnAccountPage {
	
	private WebDriver driver ;
	
	private WaitUtil waitUntil;
	
	public MagentoCreateAnAccountPage(WebDriver  driver)
	{
		this.driver = driver;
		this.waitUntil= new WaitUtil(driver);
	}
	
	private By firstName = By.xpath("//input[@name='firstname']");
	private	By lastName = By.xpath("//input[@name='lastname']");
	private	By emailId = By.xpath("//input[@name='email']");
	private	By password = By.xpath("//input[@id='password']");
	private	By confirmPassword = By.xpath("//input[@id='password-confirmation']");
	private	By createButton = By.xpath("//button[@type='submit']/span[text()='Create an Account']");
	
	   public void enterRandomEmail() {
		   
		   WebElement inputEmailID = waitUntil.waitForVisibility(emailId);
			String randomEmail = EmailGeneratorUtil.generateRandomEmail();
	        inputEmailID.sendKeys(randomEmail);
	        System.out.println("Random Email entered: " + randomEmail);
	    }
	
	public void clickOnFirstName()

	{
		
		WebElement inputFirstName = waitUntil.waitForVisibility(firstName);
		inputFirstName.click();
	}
	
	public void enterFirstName(String firstname)
	{
		WebElement inputFirstName = waitUntil.waitForVisibility(firstName);
		inputFirstName.sendKeys(firstname);
	}
	
	public void enterLastName(String lastname)
	{
		WebElement inputLastName = waitUntil.waitForVisibility(lastName);
		inputLastName.sendKeys(lastname);
	}
	
	public void enterEmailId(String emailid)
	{
		WebElement inputEmailID = waitUntil.waitForVisibility(emailId);
		inputEmailID.sendKeys(emailid);
	}
	
	public void enterEmailIdRandom(String emailid)
	{
		WebElement inputEmailID = waitUntil.waitForVisibility(emailId);
		inputEmailID.sendKeys(emailid);
	}
	
	public void enterPassowrd(String password01)
	{
		WebElement inputPassword = waitUntil.waitForVisibility(password);
		inputPassword.sendKeys(password01);
	}
	
	public void enterConfirmPassword(String confirmpassword)
	{
		WebElement inputConfirmPassword = waitUntil.waitForVisibility(confirmPassword);
		inputConfirmPassword.sendKeys(confirmpassword);
	}
	
	public void clickOncreateButton()

	{
		
		WebElement inputclick = waitUntil.waitForElementToBeClickable(createButton);
		inputclick.click();
	}
}
