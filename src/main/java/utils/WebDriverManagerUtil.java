package utils;

import base.BaseTest;
import io.cucumber.java.Scenario;

public class WebDriverManagerUtil extends BaseTest {

	public void setUpBrowser()

	{
		String browser = ConfigReader.getProperty("browser");

		initialiseDriver(browser);
		System.out.println("WebDriver initialized");
	}

	public String setUpBrowserUsingTags(Scenario scenario)

	{
		String browser = "chrome"; // Default browser
		
		
		
		if (scenario.getSourceTagNames().contains("@firefox")) {
            browser = "firefox";
        } else if (scenario.getSourceTagNames().contains("@edge")) {
            browser = "edge";
        }
		return browser;
	}
}
