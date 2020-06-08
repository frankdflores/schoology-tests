package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Courses {

	public static final String COURSE_ACTION_BUTTON = "//span[text()='%s']/ancestor::li//div[@class='action-links-unfold ']";

	private WebDriver driver;

	@FindBy(css = "a.create-course-btn")
	WebElement createCourseButton;

	public Courses(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public CreateCoursePopup openCourseModal(){

		createCourseButton.click();
		return new CreateCoursePopup(driver);

	}

	public void clickEditCourse(String courseName){

		driver.findElement(By.xpath(String.format(COURSE_ACTION_BUTTON, courseName))).click();

	}

}
