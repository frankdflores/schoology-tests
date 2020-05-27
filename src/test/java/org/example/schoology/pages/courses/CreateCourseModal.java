package org.example.schoology.pages.courses;

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
    private WebElement sectionTextField;

    @FindBy(css = "#edit-subject-area")
    private WebElement subjectArea;

    @FindBy(css = "#edit-grade-level-range-start")
    private WebElement level;

    @FindBy(css = "#edit-submit")
    private WebElement createButton;

    public CreateCourseModal(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CourseMaterials createCourse(final String courseName, final String sectionName, final String subjectArea,
                                        final String level) {
        courseNameTextField.clear();
        courseNameTextField.sendKeys(courseName);
        sectionTextField.clear();
        sectionTextField.sendKeys(sectionName);
        new Select(this.subjectArea).selectByVisibleText(subjectArea);
        new Select(this.level).selectByVisibleText(level);
        createButton.click();
        return new CourseMaterials(driver);
    }


}
