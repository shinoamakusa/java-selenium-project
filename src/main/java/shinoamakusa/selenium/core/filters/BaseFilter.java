package shinoamakusa.selenium.core.filters;

import org.openqa.selenium.By;

import shinoamakusa.selenium.core.drivers.BrowserDriver;

public class BaseFilter {

	protected BrowserDriver driver;
	protected By locator;

	public BaseFilter() {

	}

	public BaseFilter(BrowserDriver driver) {
		this.driver = driver;
	}

	public BaseFilter(BrowserDriver driver, By locator) {
		this(locator, driver);
	}

	public BaseFilter(By locator) {
		this.locator = locator;
	}

	public BaseFilter(By locator, BrowserDriver driver) {
		this.driver = driver;
		this.locator = locator;
	}

}
