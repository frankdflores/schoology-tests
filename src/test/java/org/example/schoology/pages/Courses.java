package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Courses {

	private WebDriver driver;

	public Courses(WebDriver driver) {
		this.driver = driver;
	}

	public PopupCreateCourse clickCreateCourseButton(){
		driver.findElement(By.cssSelector("a.create-course-btn")).click();
		return new PopupCreateCourse(driver);
	}

	public void clickActionCourse(String courseName){
		String courseActions = "//span[text()='%s']/ancestor::li//div[@href='#']";
		driver.findElement(By.xpath(String.format(courseActions, courseName))).click();
		driver.close();
	}
}
