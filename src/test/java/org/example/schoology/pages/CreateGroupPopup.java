package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public class CreateGroupPopup {

    private WebDriver driver;

    @FindBy(css = "#edit-name")
    private WebElement groupNameTextField;

    @FindBy(css = "#edit-description")
    private WebElement groupDescriptionTextField;

    @FindBy(css = "#edit-privacy-level")
    private WebElement privacyDropDown;

    @FindBy(css = "#edit-invite-type")
    private WebElement accessDropDown;

    @FindBy(css = "#edit-category")
    private WebElement categoryDropDown;

    @FindBy(css = "#edit-submit")
    private  WebElement submitButton;

    public CreateGroupPopup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setName(String name) {
        groupNameTextField.sendKeys(name);
    }

    public void setDescription(String description) {
        groupDescriptionTextField.sendKeys(description);
    }

    public void selectPrivacy(String privacy) {
        Select privacyField = new Select(privacyDropDown);
        privacyField.selectByVisibleText(privacy);
    }

    public void selectAccess(String access) {
        Select accessField= new Select(accessDropDown);
        accessField.selectByVisibleText(access);
    }

    public void selectCategory(String category) {
        Select categoryField = new Select(categoryDropDown);
        categoryField.selectByVisibleText(category);
    }


    public void create(Map<String, String> groupMap) {
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
    }

}
