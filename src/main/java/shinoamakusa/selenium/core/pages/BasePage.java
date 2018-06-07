package shinoamakusa.selenium.core.pages;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.drivers.DriverType;

public class BasePage {
	protected BrowserDriver driver;
	protected String sourceHTML;
	protected String title;
	protected String url;
	protected String urlPart;

	public BasePage() {
		driver = new BrowserDriver(DriverType.Chrome);
	}

	/**
	 * Closes page
	 */
	public void close() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}

	/**
	 * Validates correct page is loaded
	 * 
	 * @return True on success, false otherwise
	 */
	public boolean isValidPage() {
		return driver.urlContains(this.urlPart);
	}

	/**
	 * Opens page
	 */
	public void open() {
		driver.open();
	}

}
