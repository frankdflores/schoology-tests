package org.example.schoology.pages.courses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.schoology.entities.Course;
import org.example.schoology.pages.CreatePopup;
import org.example.schoology.pages.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCoursePopup extends CreatePopup {

	@FindBy(css = "#edit-course-name")
	private WebElement courseNameTextField;

	@FindBy(css = "#edit-section-name-1")
	private WebElement sectionNameTextField;

	@FindBy(css = "#edit-subject-area" )
	private WebElement subjectAreaDropDown;

	@FindBy(css = "#edit-grade-level-range-start")
	private WebElement levelDropDown;

	public CreateCoursePopup(WebDriver driver) {
		super(driver);
	}

	private void setName(String name) {
		courseNameTextField.sendKeys(name);
	}

	private void setSection(String section) {
		WebElement sectionField = sectionNameTextField;
		sectionField.clear();
		sectionField.sendKeys(section);
	}

	private void selectSubjectArea(String area) {
		Select subjectArea = new Select(subjectAreaDropDown);
		subjectArea.selectByVisibleText(area);
	}

	private void selectLevel(String level) {
		Select levelField = new Select(levelDropDown);
		levelField.selectByVisibleText(level);
	}

	public void create(Map<String, String> courseMap) {
		Map<String, Step> stepsMap = new HashMap<>();
		stepsMap.put("name", () -> setName(courseMap.get("name")));
		stepsMap.put("section", () -> setSection(courseMap.get("section")));
		stepsMap.put("area", () -> selectSubjectArea(courseMap.get("area")));
		stepsMap.put("level", () -> selectLevel(courseMap.get("level")));

		for (String keyField : courseMap.keySet()) {
			stepsMap.get(keyField).execute();
		}

		submitButton.click();
	}
}
