package org.example.schoology.pages;

import org.example.schoology.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractGroupPopup extends AbstractPage {
    @FindBy(css = "#edit-name")
    private WebElement groupNameTextField;

    @FindBy(css = "#edit-description")
    private WebElement descriptionTextField;

    @FindBy(css = "#edit-privacy-level" )
    private WebElement privacyDropDown;

    @FindBy(css = "#edit-invite-type")
    private WebElement accessDropDown;

    @FindBy(css = "#edit-category")
    private WebElement categoryDropDown;

    @FindBy(css = "#edit-submit")
    protected WebElement submitButton;

    @FindBy(css = "#edit-group-code")
    private WebElement codeTextField;

    public void fill(Map<String, String> groupMap) {
        Map<String, Step>  stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setName(groupMap.get("name")));
        stepsMap.put("description", () -> setDescription(groupMap.get("description")));
        stepsMap.put("privacy", () -> selectPrivacy(groupMap.get("privacy")));
        stepsMap.put("access", () -> selectAccess(groupMap.get("access")));
        stepsMap.put("category", () -> selectCategory(groupMap.get("category")));
        stepsMap.put("code", () -> setGroupCode(groupMap.get("code")));

        for(String keyField : groupMap.keySet()){
            stepsMap.get(keyField).execute();
        }
    }

    private void setName(String name) {
        WebElement groupNameField = groupNameTextField;
        groupNameField.clear();
        groupNameField.sendKeys(name);
    }

    private void setDescription(String description) {
        WebElement descriptionField = descriptionTextField;
        descriptionField.clear();
        descriptionField.sendKeys(description);
    }

    private void selectPrivacy(String privacy) {
        Select privacyField =  new Select(privacyDropDown);
        privacyField.selectByVisibleText(privacy);
    }

    private void selectAccess(String access) {
        Select accessField =  new Select(accessDropDown);
        accessField.selectByVisibleText(access);
    }

    private void selectCategory(String category) {
        Select categoryField =  new Select(categoryDropDown);
        categoryField.selectByVisibleText(category);
    }
    private void setGroupCode(String code){
        codeTextField.sendKeys(code);
    }
}
