package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Courses {

	private WebDriver driver;

	@FindBy(css = "a.create-course-btn")
	private WebElement createCourseButton;

	public Courses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public CreateCoursePopup clickCreateCourseButton() {
		createCourseButton.click();
		return new CreateCoursePopup(driver);
	}

}
