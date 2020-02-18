package autom4.HotelWebApp;


import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class DestinationPage {

	@FindBy(xpath= "//button[@type='submit']")
	private WebElement searchButton;
	
	@FindBy(xpath="//form/following-sibling::h3")
	private WebElement resultsTitle;
	
	@FindBy(xpath="//table/tbody")
	private WebElement resultsTable;
	
	public void search(WebDriver driver, String city) {
		WebElement menu = driver.findElement(By.xpath("//select[@name='ville']"));
		Select select = new Select(menu);
		select.selectByValue(city);
		searchButton.click();
	}
	
	public void checkResultsTitle(String expected) {
		String title = resultsTitle.getText();
		System.out.println("Le titre est : '" + title + "'.");
		assertEquals(expected, title);
	}
	
	public void checkTableIsDisplayed() {
		resultsTable.isDisplayed();
	}
	
	
}
