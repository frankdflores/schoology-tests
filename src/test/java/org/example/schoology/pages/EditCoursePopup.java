package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;

import java.util.Map;

public class EditCoursePopup extends AbstractCoursePopup {

	public EditCoursePopup(WebDriver driver) {
		super(driver);
	}

	public Courses edit(Map<String, String> courseMap){
		fill(courseMap);
		submitButton.click();
		return new Courses(driver);
	}
}
