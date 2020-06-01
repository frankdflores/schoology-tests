package org.example.schoology.pages;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.schoology.entities.Course;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateGroupPopup {

    @FindBy(css = "#edit-name")
    private WebElement groupNameTextField;

    @FindBy(css = "#edit-description,textarea[class='form-textarea']")
    private WebElement descriptionTextField;

    @FindBy(css = "#edit-privacy-level" )
    private WebElement privacyDropDown;

    @FindBy(css = "#edit-invite-type")
    private WebElement accessInviteTypeDropDown;

    @FindBy(css = "#edit-category")
    private WebElement categoryTypeDropDown;

    @FindBy(css = "#edit-submit")
    private  WebElement submitButton;

    private WebDriver driver;

    public CreateGroupPopup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Home create(Map<String, String> groupMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setName(groupMap.get("name")));
        stepsMap.put("description", () -> setDescription(groupMap.get("description")));
        stepsMap.put("privacy", () -> selectPrivacy(groupMap.get("privacy")));
        stepsMap.put("access", () -> selectAccess(groupMap.get("access")));
        stepsMap.put("category", () -> selectCategory(groupMap.get("category")));

        for (String keyField : groupMap.keySet()) {
            stepsMap.get(keyField).execute();
        }

        submitButton.click();
        return new Home(driver);
    }

    public void setName(String name) {
        groupNameTextField.sendKeys(name);
    }

    public void setDescription(String description) {
        WebElement descriptionField = descriptionTextField;
        descriptionField.clear();
        descriptionField.sendKeys(description);
    }

    public void selectPrivacy(String privacy) {
        Select privacyType = new Select(privacyDropDown);
        privacyType.selectByVisibleText(privacy);
    }

    public void selectAccess(String access) {
        Select accessField = new Select(accessInviteTypeDropDown);
        accessField.selectByVisibleText(access);
    }

    public void selectCategory(String category) {
        Select categoryField = new Select(categoryTypeDropDown);
        categoryField.selectByVisibleText(category);
    }


}
