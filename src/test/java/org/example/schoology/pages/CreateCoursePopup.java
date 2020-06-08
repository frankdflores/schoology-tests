package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class CreateCoursePopup {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "#edit-course-name")
    WebElement courseNameTextField;

    @FindBy(css = "#edit-section-name-1")
    WebElement sectionTextField;

    @FindBy(css = "#edit-subject-area")
    WebElement editSubjectArea;

    @FindBy(css = "#edit-grade-level-range-start")
    WebElement editGradeLevelRangeStart;

    @FindBy(css = "#edit-submit")
    WebElement createCourseButton;

    public CreateCoursePopup(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public CoursePage create(Map<String, String> courseName){

        Map<String, Step> stepsMap = new HashMap<>();

        stepsMap.put("name", () -> setName(courseName.get("name")));
        stepsMap.put("section", () -> setSection(courseName.get("section")));
        stepsMap.put("area", () -> selectSubjectArea(courseName.get("area")));
        stepsMap.put("level", () -> selectLevel(courseName.get("level")));

        for(String keyField : courseName.keySet()){
            stepsMap.get(keyField).execute();
        }

        createCourseButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#course-profile-materials")));

        return new CoursePage(driver);

    }

    public void setName(String name){
        courseNameTextField.sendKeys(name);
    }

    public void setSection(String section){
        WebElement sectionField = sectionTextField;
        sectionTextField.clear();
        sectionTextField.sendKeys(section);
    }

    public void selectSubjectArea(String area){
        Select subjectArea = new Select(editSubjectArea);
        subjectArea.selectByVisibleText(area);
    }

    public void selectLevel (String level){
        Select levelDropDown = new Select(editGradeLevelRangeStart);
        levelDropDown.selectByVisibleText(level);
    }
}
