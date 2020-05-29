package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;


public class PopupCreateGroup {

    private WebDriver driver;

    @FindBy(css = "#edit-name")
    private WebElement nameField;

    @FindBy(css = "#edit-description")
    private WebElement descriptionField;

    @FindBy(css = "#edit-privacy-level")
    private WebElement privacyField;

    @FindBy(css = "#edit-invite-type")
    private WebElement accessField;

    @FindBy(css = "#edit-category")
    private WebElement categoryField;

    @FindBy(css = "#edit-submit")
    private WebElement createButton;

    public PopupCreateGroup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public Group fillInTheFieldsAndCreate(Map<String, String> groupMap) {
        Map<String, Step> stepMap = new HashMap<>();
        stepMap.put("name", () -> setName(groupMap.get("name")));
        stepMap.put("description", () -> setDescription(groupMap.get("description")));
        stepMap.put("privacy", () -> selectPrivacy(groupMap.get("privacy")));
        stepMap.put("access", () -> selectAccess(groupMap.get("access")));
        stepMap.put("category", () -> selectCategory(groupMap.get("category")));

        for (String keyField : groupMap.keySet()) {
            stepMap.get(keyField).execute();
        }

        createButton.click();

        return new Group(driver);
    }

    public void setName(String name) {
        nameField.sendKeys(name);
    }

    public void setDescription(String description) {
        descriptionField.sendKeys(description);
    }

    public void selectPrivacy(String privacy) {
        Select selectPrivacy = new Select(privacyField);
        selectPrivacy.selectByVisibleText(privacy);
    }

    public void selectAccess(String access) {
        Select selectAccess = new Select(accessField);
        selectAccess.selectByVisibleText(access);
    }

    public void selectCategory(String category) {
        Select selectCategory = new Select(categoryField);
        selectCategory.selectByVisibleText(category);
    }
}
