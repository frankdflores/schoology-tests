package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubMenu extends AbstractPage {

	@FindBy(css = "a[href='/courses']")
	private WebElement myCoursesLink;

	@FindBy(css = "a[href='/groups']")
	private WebElement myGroupsLink;

	public Courses clickMyCoursesLink() {
		myCoursesLink.click();
		return new Courses();
	}

	public Groups clickMyGroupsLink() {
		myGroupsLink.click();
		return new Groups();
	}

}
