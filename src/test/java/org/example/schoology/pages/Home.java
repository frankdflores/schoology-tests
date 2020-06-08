package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {

	private WebDriver driver;
	private WebDriverWait wait;

	public Home(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	/**
	 * This only works for Courses and Groups
	 * Resources and More menu has another behavior.
	 * @param menuName
	 * @return
	 */
	public Object clickMenu(String menuName) {
		if (menuName.equals("Resources")) {
			driver.findElement(By.xpath(String.format("//a[text()='%s']", menuName))).click();
			return new Resources(driver);
		} else {
			driver.findElement(By.xpath(String.format("//span[text()='%s']/parent::button", menuName))).click();
			return new SubMenu(driver);
		}
	}
}
