package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubMenu {

	private WebDriver driver;

	@FindBy(css = "a[href='/courses']")
	private WebElement coursesButton;

	public SubMenu(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Courses clickMyCoursesLink() {
		coursesButton.click();
		return new Courses(driver);
	}

}
