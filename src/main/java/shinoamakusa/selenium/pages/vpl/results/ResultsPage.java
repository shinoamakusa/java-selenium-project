package main.java.shinoamakusa.selenium.pages.vpl.results;

import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;
import main.java.shinoamakusa.selenium.pages.BrowserPage;
import main.java.shinoamakusa.selenium.pages.vpl.details.DetailsPage;

public class ResultsPage extends BrowserPage {

	public String author;
	public String itemTitle;
	public String subtitle;

	public ResultsPage(BrowserDriver driver) {
		this.driver = driver;
		this.urlPart = "vpl.bibliocommons.com";
		this.title = this.driver.getTitle();
	}

	public ResultsPage broadenSearch() {
		driver.click(driver.findByClass("extendSearch"));
		return new ResultsPage(driver);

	}

	public void getResultInfo(int num) {
		driver.setParentElement(driver.findByClass("listItem", num));

		driver.select(driver.parentElement().findByAttribute("testid", "bib_link"));
		itemTitle = driver.selectedElement().getText().trim();

		driver.select(driver.parentElement().findByClass("subTitle"));
		subtitle = driver.selectedElement().getText().trim();

		driver.select(driver.parentElement().findByAttribute("testid", "author_search"));
		author = driver.selectedElement().getText().trim();
	}

	/**
	 * Gets search results count
	 * 
	 * @return Number of search results
	 */
	public int getResultsCount() {
		driver.select(driver.findByClass("items_showing_count", 1));
		assertTrue(driver.selectedElement() != null, "Results count element does not exist");

		String[] elementParts = driver.selectedElement().getText().split(" ");
		assertTrue(elementParts.length >= 5, "Results count element format is invalid");
		assertTrue(StringUtils.isNumeric(elementParts[4]), "Selected results count element part is not numeric");
		return Integer.parseInt(elementParts[4]);
	}

	public DetailsPage goToFirstResult() {
		goToResult(1);
		return new DetailsPage(driver);
	}

	public boolean searchResultsExist() {
		return getResultsCount() > 0;
	}

	/**
	 * Follows the link of the first search result
	 */
	private void goToResult(int num) {
		if (driver.parentElement() == null)
			driver.setParentElement(driver.findByClass("listItem", num));

		driver.select(driver.parentElement().findByAttribute("testid", "bib_link"));

		driver.click(driver.selectedElement());
	}

}
