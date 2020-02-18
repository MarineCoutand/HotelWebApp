package autom4.HotelWebApp;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;




public class HotelWebAppTest {

	private WebDriver driver = new FirefoxDriver();
	private String ville1="Londres";
	private String expected1="Hôtels disponibles à Londres";
	
	@Test
	public void test() {
		
		driver.get("http://192.168.102.76:9996/HotelWebapp/");
		driver.manage().window().maximize();
		DestinationPage destinationPage = PageFactory.initElements(driver, DestinationPage.class);
		
		//Clic sur Londres
		destinationPage.search(driver, ville1);
		
		//Vérification des résultats
		destinationPage.checkResultsTitle(expected1);
		destinationPage.checkTableIsDisplayed();
	}
	
	
}
