package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Courses {

	private WebDriver driver;

	@FindBy(css = "a.create-course-btn")
	private WebElement CreateCourseButton;

	public Courses(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public PopupCreateCourse clickCreateCourseButton(){
		CreateCourseButton.click();
		return new PopupCreateCourse(driver);
	}

	public void clickActionCourse(String courseName){
		String courseActions = "//span[text()='%s']/ancestor::li//div[@href='#']";
		driver.findElement(By.xpath(String.format(courseActions, courseName))).click();
		driver.close();
	}
}
