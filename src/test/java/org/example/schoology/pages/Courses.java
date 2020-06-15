package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Courses extends AbstractPage {

	public static final String COURSE_ACTIONS_BUTTON = "//span[text()='%s']/ancestor::li//div[@class='action-links-unfold ']";
	public static final String XPATH_SECTION_BY_NAME = "//span[text()='%s']/parent::p/parent::li//a[@class='sExtlink-processed']";

	@FindBy(css = "a.create-course-btn")
	private WebElement createCourseButton;

	@FindBy(css = "ul[style=\"display: block;\"] .action-edit")
	private WebElement editCourse;

	@FindBy(css = ".messages .message-text")
	private WebElement messages;

	public CreateCoursePopup clickCreateCourseButton() {
		createCourseButton.click();
		return new CreateCoursePopup();
	}

	public EditCoursePopup clickEditCourse(String courseName) {
		WebElement courseActionsButton = driver.findElement(By.xpath(String.format(COURSE_ACTIONS_BUTTON, courseName)));

		// Scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", courseActionsButton);

		courseActionsButton.click();
		editCourse.click();
		return new EditCoursePopup();
	}

	public String getMessage() {
		return messages.getText();
	}

	public String getSectionByName(String courseName) {
		return driver.findElement(By.xpath(String.format(XPATH_SECTION_BY_NAME, courseName))).getText();
	}
}
