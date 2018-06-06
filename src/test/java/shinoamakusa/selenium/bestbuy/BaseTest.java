package test.java.shinoamakusa.selenium.bestbuy;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import main.java.shinoamakusa.selenium.pageobjects.bestbuy.home.HomePage;
import main.java.shinoamakusa.selenium.pageobjects.bestbuy.results.ResultsPage;

public class BaseTest {
	protected HomePage homepage;
	protected final String query = "windows laptops";
	protected ResultsPage resultsPage;

	@AfterMethod
	public void after() {
		assertTrue(resultsPage.itemCountsEqual());
		assertTrue(resultsPage.perPageOptionsWork());
		resultsPage.close();
	}

	@BeforeMethod
	public void before() {
		homepage = new HomePage();
		homepage.open();
		assertTrue(homepage.isValidPage());
		resultsPage = homepage.searchFor(query);
		assertTrue(resultsPage.isValidPage());
	}

}
