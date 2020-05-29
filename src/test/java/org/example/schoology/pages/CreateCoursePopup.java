package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public class CreateCoursePopup {
    @FindBy(css = "#edit-course-name")
    private WebElement courseNameTextField;

    @FindBy(css = "#edit-section-name-1")
    private WebElement sectionNameTextField;

    @FindBy(css = "#edit-subject-area" )
    private WebElement subjectAreaDropDown;

    @FindBy(css = "#edit-grade-level-range-start")
    private WebElement levelDropDown;

    @FindBy(css = "#edit-submit")
    private WebElement submitButton;

    private WebDriver driver;

    public CreateCoursePopup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void create(Map<String, String> courseMap) {
        Map<String, Step>  stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setName(courseMap.get("name")));
        stepsMap.put("section", () -> setSection(courseMap.get("section")));
        stepsMap.put("area", () -> selectArea(courseMap.get("area")));
        stepsMap.put("level", () -> selectLevel(courseMap.get("level")));

        for(String keyField : courseMap.keySet()){
            stepsMap.get(keyField).execute();
        }

    }

    private void setName(String name) {
        courseNameTextField.sendKeys(name);
    }

    private void setSection(String section) {
        WebElement sectionField = sectionNameTextField;
        sectionField.clear();
        sectionField.sendKeys(section);
    }

    private void selectArea(String area) {
        Select subjectArea =  new Select(subjectAreaDropDown);
        subjectArea.selectByVisibleText(area);
    }

    public void selectLevel(String level) {
        Select levelField = new Select(levelDropDown);
        levelField.selectByVisibleText(level);
    }
}
