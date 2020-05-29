package org.example.schoology.pages;

import org.example.schoology.pages.courses.CoursesSubMenu;
import org.example.schoology.pages.groups.GroupsSubMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {

	private WebDriver driver;

	public Home(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This only works for Courses and Groups
	 * Resources and More menu has another behavior.
	 * @param menuName
	 * @return
	 */
	public void clickMenu(String menuName) {
		driver.findElement(By.xpath(String.format("//span[text()='%s']/parent::button", menuName))).click();
	}

	public CoursesSubMenu clickCoursesMenu() {
		clickMenu("Courses");
		return new CoursesSubMenu(driver);
	}

	public GroupsSubMenu clickGroupsMenu() {
		clickMenu("Groups");
		return new GroupsSubMenu(driver);
	}
}
