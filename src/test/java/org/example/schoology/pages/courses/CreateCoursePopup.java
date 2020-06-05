package org.example.schoology.pages.courses;

import java.util.Map;

import org.example.schoology.pages.CreatePopup;
import org.example.schoology.pages.Step;
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
}
