package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Courses {

	private WebDriver driver;

	@FindBy(css = "a.create-course-btn")
	private WebElement button_create_course;


	public Courses(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public CourseForm createCourseAction(){
		button_create_course.click();
		return new CourseForm(driver);
	}

	public CourseForm editCourseAction(String courseName){
		String courseActions = "//span[text()='%s']/ancestor::li//div[@class='action-links-unfold ']";
		driver.findElement(By.xpath(String.format(courseActions, courseName))).click();
		return new CourseForm(driver);
	}

}
