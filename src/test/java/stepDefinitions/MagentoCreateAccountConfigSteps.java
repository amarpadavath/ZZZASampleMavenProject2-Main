package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MagentoAccountPage;
import pages.MagentoCreateAnAccountPage;
import pages.MagentoHeader;
import pages.MagentoLoginpage;
import utils.ConfigReader;
import utils.EmailGeneratorUtil;
import utils.LogUtil;

public class MagentoCreateAccountConfigSteps extends BaseTest {

	MagentoHeader header;
	MagentoCreateAnAccountPage createAnAccountPage;
	ConfigReader config = new ConfigReader(); // Load config.properties
	MagentoLoginpage loginpage;
	MagentoAccountPage accountPage;
	private String generatedEmail;

	@Given("I am on the create account page")
	public void i_am_on_the_create_account_page() {
		// Write code here that turns the phrase above into concrete actions

		// driver= new ChromeDriver();
		if (driver != null) {
			driver.get(ConfigReader.getProperty("appURL"));
		} else {
			throw new NullPointerException("WebDriver is not initialized");
		}

		loginpage = new MagentoLoginpage(driver);
		accountPage = new MagentoAccountPage(driver);
		header = new MagentoHeader(driver);
		createAnAccountPage = new MagentoCreateAnAccountPage(driver);

		header.clickOnSignInButton();
		loginpage.clickOnCreateButtom();
		
		LogUtil.info("Navigated");

	}

	@When("I enter valid data to create account")
	public void i_enter_valid_data_to_create_account() {

	generatedEmail = EmailGeneratorUtil.generateRandomEmail();
		// Enter form details
		createAnAccountPage.clickOnFirstName();
		createAnAccountPage.enterFirstName(ConfigReader.getProperty("cfirstName"));
		createAnAccountPage.enterLastName(ConfigReader.getProperty("clastName"));
		// createAnAccountPage.enterEmailId(ConfigReader.getProperty("cemailId"));
		//createAnAccountPage.enterRandomEmail();
		createAnAccountPage.enterEmailId(generatedEmail);
		createAnAccountPage.enterPassowrd(ConfigReader.getProperty("cpassword"));
		createAnAccountPage.enterConfirmPassword(ConfigReader.getProperty("cconfirmPassword"));
		createAnAccountPage.clickOncreateButton();
		
		LogUtil.info("Account created");

	}

	@Then("Successfull accounts creation validation")
	public void successfull_accounts_creation_validation() {
		// Write code here that turns the phrase above into concrete actions
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		LogUtil.info("Validation is.......");

		String successfulText = accountPage.getSuccessText();

		System.out.println("actual text- " + successfulText);

		System.out.println("expetcted text- " + "Thank you for registering with Main Website Store.");

		Assert.assertEquals(successfulText, "Thank you for registering with Main Website Store.");
		// String emailText = accountPage.getEmailText();

		String nameText = accountPage.getNameText();

		System.out.println(nameText);
		System.out.println(generatedEmail);
		Assert.assertTrue(nameText.contains(generatedEmail));

		

	}

}
