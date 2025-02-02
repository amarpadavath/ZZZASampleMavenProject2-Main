package utils;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	public static void takeScreenshot(WebDriver driver,String fileName)
	{
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File(System.getProperty("user.dir") + "/screenshots/" + fileName + ".png");
		
		try
		{
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
			
		}
		
		catch (IOException e) {
            e.printStackTrace();
        }
		
		
	}

}
