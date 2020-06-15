package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.By;


public class Home extends AbstractPage {

	/**
	 * This only works for Courses and Groups
	 * Resources and More menu has another behavior.
	 * @param menuName
	 * @return
	 */
	public Object clickMenu(String menuName) {

		if (menuName.equals("Resources")){
			driver.findElement(By.xpath(String.format("//a[text()='%s']", menuName))).click();
			return new Resources();
		} else {
			driver.findElement(By.xpath(String.format("//span[text()='%s']/parent::button", menuName))).click();
			return new SubMenu();
		}
	}

}
