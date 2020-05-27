package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCourseModal {

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

    public CreateCourseModal(WebDriver driver){
        this.driver = driver;
		PageFactory.initElements(driver, this);
    }

    public Materials createCourse(String courseName, String Section, String Subject, String level){
		courseNameTextField.sendKeys(courseName);
		WebElement sectionField = sectionNameTextField;
		sectionField.clear();
		sectionField.sendKeys(Section);

		Select subjectArea = new Select(subjectAreaDropDown);
		subjectArea.selectByVisibleText(Subject);

		Select levelField = new Select(levelDropDown);
		levelField.selectByVisibleText(level);

		submitButton.click();

		return new Materials(driver);
    }

}
