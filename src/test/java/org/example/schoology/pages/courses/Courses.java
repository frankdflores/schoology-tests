package org.example.schoology.pages.courses;

import org.example.schoology.pages.ViewList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Courses extends ViewList {

	public static final String COURSE_ACTIONS_BUTTON = "//span[text()='%s']/ancestor::li//div[@class='action-links-unfold ']";
	public static final String XPATH_SECTION_BY_NAME = "//span[text()='%s']/parent::p/parent::li//a[@class=\"sExtlink-processed\"]";

	@FindBy(css = "a.create-course-btn" )
	private WebElement createCourseButton;

	@FindBy(css = "ul[style='display: block;'] .action-edit")
	private WebElement editCourse;

	@FindBy(css = "ul[style='display: block;'] .action-delete-link")
	private WebElement deleteCourse;

	public CreateCoursePopup clickCreateCourseButton(){
		createCourseButton.click();
		return new CreateCoursePopup();
	}

    public EditCoursePopup clickEditCourse(String courseName) {

		driver.findElement(By.xpath(String.format(COURSE_ACTIONS_BUTTON, courseName))).click();
		//Scroll
		//WebElement courseActionButton = driver.findElement(By.xpath(String.format(COURSE_ACTIONS_BUTTON, courseName)));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView();", courseActionButton);
		//courseActionButton.click();
		editCourse.click();
		return new EditCoursePopup();
    }

	public DeleteCoursePopup clickDeleteCourse(final String courseName) {

		driver.findElement(By.xpath(String.format(COURSE_ACTIONS_BUTTON, courseName))).click();
		//Scroll
		//WebElement courseActionButton = driver.findElement(By.xpath(String.format(COURSE_ACTIONS_BUTTON, courseName)));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView();", courseActionButton);
		//courseActionButton.click();
		deleteCourse.click();
		return new DeleteCoursePopup();
	}

	public String getSectionByName(String courseName){
		return driver.findElement(By.xpath(String.format(XPATH_SECTION_BY_NAME, courseName))).getText();
	}
}
