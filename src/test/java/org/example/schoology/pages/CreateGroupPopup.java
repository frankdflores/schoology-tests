package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public class CreateGroupPopup {

    @FindBy(css = "#edit-name")
    private WebElement groupNameTextField;

    @FindBy(css = "#edit-description")
    private WebElement groupDescriptionTextField;

    @FindBy(css = "#edit-privacy-level" )
    private WebElement privacyLevelDropDown;

    @FindBy(css = "#edit-invite-type")
    private WebElement inviteTypeDropDown;

    @FindBy(css = "#edit-category")
    private WebElement categoryDropDown;

    @FindBy(css = "#edit-submit")
    private  WebElement submitButton;

    private WebDriver driver;

    public CreateGroupPopup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void create(Map<String, String> groupMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setName(groupMap.get("name")));
        stepsMap.put("description", () -> setDescription(groupMap.get("section")));
        stepsMap.put("privacy", () -> selectPrivacyLevel(groupMap.get("privacy")));
        stepsMap.put("access", () -> selectInviteType(groupMap.get("access")));
        stepsMap.put("category", () -> selectCategory(groupMap.get("category")));

        for (String keyField : groupMap.keySet()) {
            stepsMap.get(keyField).execute();
        }

        submitButton.click();
    }

    public void setName(String name) {
        groupNameTextField.sendKeys(name);
    }

    public void setDescription(String description) {
        groupDescriptionTextField.sendKeys(description);
    }

    public void selectPrivacyLevel(String privacyLevel) {
        Select subjectArea = new Select(privacyLevelDropDown);
        subjectArea.selectByVisibleText(privacyLevel);
    }

    public void selectInviteType(String inviteType) {
        Select subjectArea = new Select(inviteTypeDropDown);
        subjectArea.selectByVisibleText(inviteType);
    }

    public void selectCategory(String category) {
        Select subjectArea = new Select(categoryDropDown);
        subjectArea.selectByVisibleText(category);
    }
}
