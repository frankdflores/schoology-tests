package org.example.schoology.pages;

import org.example.schoology.entities.Course;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public class CreateCoursePopup {

    private WebDriver driver;

    @FindBy(css = "#edit-course-name")
	private WebElement courseNameTextField;

    @FindBy(css = "#edit-section-name-1")
	private WebElement sectionNameTextField;

    @FindBy(css = "#edit-subject-area" )
	private WebElement subjectAreaDropDown;

    @FindBy(css = "#edit-grade-level-range-start")
	private WebElement levelDropDown;

    @FindBy(css = "#edit-submit")
	private  WebElement submitButton;

    public CreateCoursePopup(WebDriver driver){
        this.driver = driver;
		PageFactory.initElements(driver, this);
    }

    public Materials create(Map<String, String> courseMap){
		Map<String, Step> stepsMap = new HashMap<>();
		stepsMap.put("name", () -> setName(courseMap.get("name")));
		stepsMap.put("section", () ->setSection(courseMap.get("section")));
		stepsMap.put("area", () ->selectSubjectArea(courseMap.get("area")));
		stepsMap.put("level", () ->selectLevel(courseMap.get("level")));

		for(String keyField: courseMap.keySet()){
			stepsMap.get(keyField).execute();
		}

		submitButton.click();

		return new Materials(driver);
	}

	public void setName(String name){
		courseNameTextField.sendKeys(name);

	}

	public void setSection(String section){
		WebElement sectionField = sectionNameTextField;
		sectionField.clear();
		sectionField.sendKeys(section);
	}

	public void selectSubjectArea(String area){
		Select subjectArea = new Select(subjectAreaDropDown);
		subjectArea.selectByVisibleText (area);
	}

	public void selectLevel(String level){
		Select levelField = new Select(levelDropDown);
		levelField.selectByVisibleText(level);
	}

}
