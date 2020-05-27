package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCourse {

    private WebDriver driver;

    @FindBy(css = "#edit-course-name")
    WebElement editCourseName;

    @FindBy(css = "#edit-section-name-1")
    WebElement sectionField;

    @FindBy(css = "#edit-subject-area")
    WebElement editSubjectArea;

    @FindBy(css = "#edit-grade-level-range-start")
    WebElement editGradeLevelRangeStart;

    @FindBy(css = "#edit-submit")
    WebElement createCourseButton;

    public CreateCourse(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Materials  createNewCourse(String courseName){

        editCourseName.sendKeys(courseName);
        sectionField.clear();
        sectionField.sendKeys("Section");
        Select subjectArea = new Select(editSubjectArea);
        subjectArea.selectByVisibleText("Mathematics");
        Select level = new Select(editGradeLevelRangeStart);
        level.selectByVisibleText("Undergraduate");
        createCourseButton.click();

        return new Materials(driver);
    }
}
