package runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utils.ExtentReportUtil;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/DermoQA_TextBox.feature", 
					glue = { "stepDefinitions","hooks" }, 
				//	tags = "@edge", 
					plugin = { "pretty", "html:target/cucumber-reports.html" }
					//dryRun = true,
					//monochrome = true

		)

public class TestRunner {
	
	  @BeforeClass
	    public static void setup() {
	        // Initialize Extent Reports before test execution
	        ExtentReportUtil.initExtentReport();
	    }

	    @AfterClass
	    public static void tearDown() {
	        // Flush Extent Reports after all tests are completed
	        ExtentReportUtil.flushExtentReport();
	    }

}
