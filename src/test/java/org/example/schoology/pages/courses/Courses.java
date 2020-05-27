package org.example.schoology.pages.courses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Courses {

	private WebDriver driver;

	@FindBy(css = "a.create-course-btn")
	private WebElement createCourseButton;

	private static final String COURSE_ACTIONS = "//span[text()='%s']/ancestor::li//div[@class='action-links-unfold ']";

	public Courses(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public CreateCourseModal clickCreateCourseButton() {
		createCourseButton.click();
		return new CreateCourseModal(driver);
	}

	public void expandActionsMenuForCourse(final String courseName) {
		driver.findElement(By.xpath(String.format(COURSE_ACTIONS, courseName))).click();
	}
}
