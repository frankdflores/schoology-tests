package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractGroupPopup extends AbstractPage {

    @FindBy(css = "#edit-name")
    private WebElement nameField;

    @FindBy(css = "#edit-description")
    private WebElement descriptionField;

    @FindBy(css = "#edit-group-code")
    private WebElement groupCodeField;

    @FindBy(css = "#edit-privacy-level")
    private WebElement privacyField;

    @FindBy(css = "#edit-invite-type")
    private WebElement accessField;

    @FindBy(css = "#edit-category")
    private WebElement categoryField;

    @FindBy(css = "#edit-submit")
    protected WebElement submitButton;

    public void fill(Map<String, String> groupMap) {
        Map<String, Step> stepMap = new HashMap<>();
        stepMap.put("name", () -> setName(groupMap.get("name")));
        stepMap.put("description", () -> setDescription(groupMap.get("description")));
        stepMap.put("groupCode", () -> setGroupCode(groupMap.get("groupCode")));
        stepMap.put("privacy", () -> selectPrivacy(groupMap.get("privacy")));
        stepMap.put("access", () -> selectAccess(groupMap.get("access")));
        stepMap.put("category", () -> selectCategory(groupMap.get("category")));

        for (String keyField : groupMap.keySet()) {
            stepMap.get(keyField).execute();
        }
    }

    public void setName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void setDescription(String description) {
        descriptionField.clear();
        descriptionField.sendKeys(description);
    }

    public void setGroupCode(String code) {
        groupCodeField.clear();
        groupCodeField.sendKeys(code);
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
