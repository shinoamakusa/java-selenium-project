package shinoamakusa.selenium.tests.vpl;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import shinoamakusa.selenium.pages.vpl.details.DetailsPage;

public class DetailsInfoCheck extends BaseTest {
	@Test
	public void detailsInfoCheck() {
		resultsPage.getResultInfo(1);
		DetailsPage detailsPage = resultsPage.goToFirstResult();
		detailsPage.getDetails();
		assertTrue(
				(resultsPage.itemTitle.equalsIgnoreCase(detailsPage.itemTitle))
						&& (resultsPage.subtitle.equalsIgnoreCase(detailsPage.subtitle))
						&& (resultsPage.author.equalsIgnoreCase(detailsPage.author)),
				"Item information on the results and details pages is not the same");
	}

}
