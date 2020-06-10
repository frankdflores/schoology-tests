package org.example.schoology.pages;

import org.example.schoology.pages.courses.CoursesSubMenu;
import org.example.schoology.pages.groups.GroupsSubMenu;
import org.example.schoology.pages.resources.MyResources;
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
	public void clickMenu(String menuName) {
		driver.findElement(By.xpath(String.format("//*[text()='%s' and (self::a or self::span)]", menuName))).click();
	}

	public CoursesSubMenu clickCoursesMenu() {
		clickMenu("Courses");
		return new CoursesSubMenu(driver);
	}

	public GroupsSubMenu clickGroupsMenu() {
		clickMenu("Groups");
		return new GroupsSubMenu(driver);
	}

	public MyResources clickResourcesMenu() {
		clickMenu("Resources");
		return new MyResources(driver);
	}
}
