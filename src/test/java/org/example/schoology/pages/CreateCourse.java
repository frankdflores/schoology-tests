package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCourse {
    WebDriver driver;

    @FindBy(css = "#edit-course-name")
    WebElement editCourseName;

    @FindBy(css = "#edit-section-name-1")
    WebElement editSectionName;

    @FindBy(css = "#edit-subject-area")
    WebElement editSubjectArea;

    @FindBy(css = "#edit-grade-level-range-start")
    WebElement editGradeCourse;

    @FindBy(css = "#edit-submit")
    WebElement createCourseButton;


    public CreateCourse(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createCourse(String courseName, String courseSection, String courseSubject, String courseGrade) {
        this.editCourseName.sendKeys(courseName);
        this.editSectionName.clear();
        this.editSectionName.sendKeys(courseSection);
        Select subjectArea = new Select(this.editSubjectArea);
        subjectArea.selectByVisibleText(courseSubject);
        Select gradeCourse = new Select(this.editGradeCourse);
        gradeCourse.selectByVisibleText(courseGrade);
        this.createCourseButton.click();
    }
}
