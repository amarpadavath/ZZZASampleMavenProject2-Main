package SeleniumSeperate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test001WebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///F:/NotepadPrograms/Notes/2.Selenium/WebTable.html");
		
		List<WebElement> s = driver.findElements(By.xpath("//table/tbody/tr"));
		
		for(WebElement w : s)
		{
			
			 List < WebElement > allCells = w.findElements(By.tagName("td"));

	            // Loop through each cell
	            for (WebElement cell: allCells) {
	                System.out.print(cell.getText() + "\t");
	            }

	            System.out.println(); // Newline after each row
	        }

			
		
		
		
		

	}

}
