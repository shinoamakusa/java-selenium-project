package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.PageElement;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class UsedFilter extends BaseFilter {
	public UsedFilter(BrowserDriver driver) {
		this.driver = driver;
		this.locator = ByLocator.attribute("for", "oneSearchAdUsed");
	}
	
	public void select(boolean checked)
	{
		PageElement container = driver.findByLocator(this.locator);
		if (container.findByName("onesearchad").hasSelectedState(!checked)) {
			driver.click(container);
		}
	}

}
