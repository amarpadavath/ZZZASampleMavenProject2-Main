package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DemoQAHomePage;
import pages.DemoQATextBoxPage;
import utils.ConfigReader;

public class DemoQATextSteps extends BaseTest {
	
	DemoQAHomePage homepage;
	DemoQATextBoxPage textBoxpage;
	ConfigReader config = new ConfigReader();
	
	

	@Given("I launched websites")
	public void i_launched_websites() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		

		// driver= new ChromeDriver();
		if (driver != null) {
			driver.get(ConfigReader.getProperty("appURL1"));
		} else {
			throw new NullPointerException("WebDriver is not initialized");
		}
		
		homepage = new DemoQAHomePage(driver);
		textBoxpage = new DemoQATextBoxPage(driver);
		
		homepage.clickOnElementsJS();
		
		
	}
	@When("I enter data in form")
	public void i_enter_data_in_form() {
		
		textBoxpage.clickOntextBoxAccordion();
		textBoxpage.inputFullName("Amar");
		textBoxpage.inputEmailAddress("test@gmail.com");
		textBoxpage.inputCurrentAdd("test");
		textBoxpage.inputPermenantAdd("test");
		textBoxpage.clickOnSubmitElementsJS();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@Then("I validate the data entered in form")
	public void i_validate_the_data_entered_in_form() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}




}
