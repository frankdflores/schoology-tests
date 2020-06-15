package org.example.schoology.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCoursePopup extends AbstractCoursePopup {

	public Courses edit(Map<String, String> courseMap) {
		fill(courseMap);
		submitButton.click();
		return new Courses();
	}

}
