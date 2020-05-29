package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PopupCreateCourse {

    private WebDriver driver;

    @FindBy(css = "#edit-course-name")
    private WebElement courseNameField;

    @FindBy(css = "#edit-section-name-1")
    private WebElement sectionField;

    @FindBy(css = "#edit-subject-area")
    private WebElement subjectAreaField;

    @FindBy(css = "#edit-grade-level-range-start")
    private WebElement levelField;

    @FindBy(css = "#edit-submit")
    private WebElement submitButton;


    public PopupCreateCourse(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Materials fillInTheFieldsAndCreate(String courseName, String sectionName, String subjectArea, String level){
        courseNameField.sendKeys(courseName);

        sectionField.clear();
        sectionField.sendKeys(sectionName);

        Select subjectAreaSelect = new Select(subjectAreaField);
        subjectAreaSelect.selectByVisibleText(subjectArea);

		Select levelSelect= new Select(levelField);
        levelSelect.selectByVisibleText(level);

        submitButton.click();
        return  new Materials(driver);
    }
}
