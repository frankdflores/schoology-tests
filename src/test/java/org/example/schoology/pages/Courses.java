package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Courses {

	private WebDriver driver;

	public Courses(WebDriver driver) {
		this.driver = driver;
	}

	public PopupCreateCourse clickCreateCourse(){
		driver.findElement(By.cssSelector("a.create-course-btn")).click();
		return new PopupCreateCourse(driver);
	}
}
