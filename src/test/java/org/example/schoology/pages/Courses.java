package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Courses {

//    private final WebDriver driver;
//
//    @FindBy(css = "a.create-course-btn")
//    private WebElement newCourseButton;
//
//    @FindBy(css = "#edit-course-name")
//    private WebElement courseNameTextField;
//
//    @FindBy(css = "#edit-section-name-1")
//    private WebElement sectionTextField;
//
//    @FindBy(css = "#edit-subject-area")
//    private WebElement subjectAreaSelect;
//
//    @FindBy(css = "#edit-grade-level-range-start")
//    private WebElement levelSelect;
//
//    @FindBy(css = "#edit-submit")
//    private WebElement saveButton;
//
//    public Courses(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//
//
//    public Materials createCourse(String courseName, String sectionName, String subjectArea, String level) {
//        newCourseButton.click();
//        courseNameTextField.clear();
//        courseNameTextField.sendKeys(courseName);
//        sectionTextField.clear();
//        sectionTextField.sendKeys(sectionName);
//        Select subjectAreaWebElement = new Select(subjectAreaSelect);
//        subjectAreaWebElement.selectByVisibleText(subjectArea);
//        Select levelWebElement = new Select(levelSelect);
//        levelWebElement.selectByVisibleText(level);
//        saveButton.click();
//        return new Materials(driver);
//    }
//
//    public void courseActions(String courseName) {
//        String courseActions = "//span[text()='%s']/ancestor::li//div[@class='action-links-unfold ']";
//        driver.findElement(By.xpath(String.format(courseActions, courseName))).click();
//    }
//
//    public void endProcess() {
//        driver.quit();
//    }

    private WebDriver driver;

    @FindBy(css = "a.create-course-btn")
    private WebElement createCourseButton;

    public Courses(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateCoursePopup clickCreateCourseButton() {
        createCourseButton.click();
        return new CreateCoursePopup(driver);
    }
}
