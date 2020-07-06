package org.example.schoology.pages;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.resources.Resources;
import org.openqa.selenium.By;

public class Home extends AbstractPage {

	/**
	 * This only works for Courses and Groups
	 * Resources and More menu has another behavior.
	 * @param menuName
	 * @return
	 */
	public SubMenu clickMenu(String menuName) {
		driver.findElement(By.xpath(String.format("//span[text()='%s']/parent::button", menuName))).click();
		return new SubMenu();
	}

	public Resources clickResourcesMenu(String menuName) {
		driver.findElement(By.xpath(String.format("//a[text()='Resources']", menuName))).click();
		return new Resources();
	}

}
