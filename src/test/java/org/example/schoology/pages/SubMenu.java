package org.example.schoology.pages;

import org.example.schoology.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubMenu extends AbstractPage {

	@FindBy(css = "a[href='/courses']")
	private WebElement myCoursesLink;

	@FindBy(css = "a[href='/groups']")
	private WebElement myGroupsLink;


	public Courses clickMyCoursesLink() {
		driver.findElement(By.cssSelector("a[href='/courses']")).click();
		return new Courses();
	}

	public Groups clickMyGroupsLink() {
		driver.findElement(By.cssSelector("a[href='/groups']")).click();
		return new Groups();
	}

}
