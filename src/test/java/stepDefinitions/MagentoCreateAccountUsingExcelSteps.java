package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;

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
import utils.ExcelUtility;
import utils.LogUtil;

public class MagentoCreateAccountUsingExcelSteps extends BaseTest {

	MagentoHeader header;
	MagentoCreateAnAccountPage createAnAccountPage;
	ConfigReader config = new ConfigReader(); // Load config.properties
	MagentoLoginpage loginpage;
	MagentoAccountPage accountPage;
	private String generatedEmail;

	@Given("I have the data from Excel file")
	public void i_have_the_data_from_excel_file() throws IOException {
		// Write code here that turns the phrase above into concrete actions

		ExcelUtility.initializeExcel("src/test/resources/ExcelData2.xlsx", "Sheet1");

		// Get data from the Excel sheet
		String url = ExcelUtility.getCellData(1, 0);
		
		System.out.println(url);
		
		// driver= new ChromeDriver();
		if (driver != null) {
			driver.get(url);
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

	@When("I enter data from Excel to create an account")
	public void i_enter_data_from_excel_to_create_an_account() {
		// Enter the fetched data into your web 
		generatedEmail = EmailGeneratorUtil.generateRandomEmail();
		String firstName = ExcelUtility.getCellData(1, 1);
		String lastName = ExcelUtility.getCellData(1, 2);
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		createAnAccountPage.enterFirstName(firstName); // First Name from Excel
		createAnAccountPage.enterLastName(lastName); // Last Name from Excel
		createAnAccountPage.enterEmailId(generatedEmail);
		createAnAccountPage.enterPassowrd(ConfigReader.getProperty("cpassword"));
		createAnAccountPage.enterConfirmPassword(ConfigReader.getProperty("cconfirmPassword"));
		createAnAccountPage.clickOncreateButton();
	}

	@Then("I validate the account creation and write result to Excel")
	public void i_validate_the_account_creation_and_write_result_to_excel() throws IOException {
		// Validate account creation
		String successfulText = accountPage.getSuccessText();

		System.out.println("actual text- " + successfulText);

		System.out.println("expetcted text- " + "Thank you for registering with Main Website Store.");

		Assert.assertEquals(successfulText, "Thank you for registering with Main Website Store.");
		// String emailText = accountPage.getEmailText();

		String nameText = accountPage.getNameText();

		System.out.println(nameText);
		System.out.println(generatedEmail);
		Assert.assertTrue(nameText.contains(generatedEmail));

		// Write test result back to the Excel sheet
		ExcelUtility.setCellData(1, 5, "Passed");

		// Close the Excel file after writing data
		ExcelUtility.closeExcel();
	}
}