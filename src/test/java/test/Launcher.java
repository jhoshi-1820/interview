package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.*;

public class Launcher {
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.microsoft.com/es-mx/");
	}
	
	@Test
	public void searchValidation() {
		MicrosoftPage microsoftPage = new MicrosoftPage(driver);
		microsoftPage.clickWindowsButton();

		WindowsPage windowsPage = new WindowsPage(driver);
		windowsPage.clickSearchIcon();
		windowsPage.search("Xbox");

		SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
		searchResultsPage.popup.close();
		searchResultsPage.clickComprarTab();
		searchResultsPage.clickAplicacionesTab();

		int numberOfPagesToSearch = 3;
		String firstPrice = "";

		AplicacionesPage aplicacionesPage = new AplicacionesPage(driver);
		aplicacionesPage.countItemsPerPage(numberOfPagesToSearch);
		aplicacionesPage.goToPage(1);
		firstPrice = aplicacionesPage.getFirstItemPrice().getText();
		aplicacionesPage.selectFirstItemWithPrice();

		ItemDetailsPage itemDetailsPage = new ItemDetailsPage(driver);
		String currentPrice = itemDetailsPage.getItemPriceLabel().getText();

		Assert.assertEquals("El precio no coincide", firstPrice, currentPrice);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
