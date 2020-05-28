package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubMenu {

	private WebDriver driver;

	public SubMenu(WebDriver driver) {
		this.driver = driver;
	}

	public Courses clickMyCoursesLink() {
		driver.findElement(By.cssSelector("a[href='/courses']")).click();
		return new Courses(driver);
	}
	public Groups clickMyGroupsLink() {
		driver.findElement(By.cssSelector("a[href='/groups']")).click();
		return new Groups(driver);
	}
}
