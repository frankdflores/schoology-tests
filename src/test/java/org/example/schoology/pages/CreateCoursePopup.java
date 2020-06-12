package org.example.schoology.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;

public class CreateCoursePopup extends AbstractCoursePopup {

	public CreateCoursePopup(WebDriver driver) {
		super(driver);
	}

	public CoursePage create(Map<String, String> courseMap) {
		fill(courseMap);
		submitButton.click();
		return new CoursePage(driver);
	}

}
