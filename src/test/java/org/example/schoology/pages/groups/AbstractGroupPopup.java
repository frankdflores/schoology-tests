package org.example.schoology.pages.groups;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public class AbstractGroupPopup extends AbstractPage {

    @FindBy(css = "#edit-name")
    private WebElement groupNameTextField;

    @FindBy(css = "#edit-description")
    private WebElement descriptionTextField;

    @FindBy(css = "#edit-group-code")
    private WebElement groupCodeTextField;

    @FindBy(css = "#edit-privacy-level" )
    private WebElement privacyDropDown;

    @FindBy(css = "#edit-invite-type")
    private WebElement accessDropDown;

    @FindBy(css = "#edit-category")
    private WebElement categoryDropDown;

    @FindBy(css = "#edit-submit")
    protected WebElement submitButton;

    public void fill(Map<String, String> groupMap){
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setName(groupMap.get("name")));
        stepsMap.put("description", () ->setDescription(groupMap.get("description")));
        stepsMap.put("code", () ->setGroupCode(groupMap.get("code")));
        stepsMap.put("privacy", () ->selectPrivacy(groupMap.get("privacy")));
        stepsMap.put("access", () ->selectAccess(groupMap.get("access")));
        stepsMap.put("category", () ->selectCategory(groupMap.get("category")));

        for(String keyField: groupMap.keySet()){
            stepsMap.get(keyField).execute();
        }
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#feed-empty-message")));
    }

    //public void setName(String name){
    //    groupNameTextField.sendKeys(name);
    //}

    //public void setDescription(String description){
    //    descriptionTextField.sendKeys(description);
    //}
    private void setName(String name){
        groupNameTextField.clear();
        groupNameTextField.sendKeys(name);
    }

    private void setDescription(String description){
        WebElement descriptionField = descriptionTextField;
        descriptionField.clear();
        descriptionField.sendKeys(description);
    }

    private void setGroupCode(String code){
        groupCodeTextField.sendKeys(code);
    }

    private void selectPrivacy(String privacy){
        Select privacyField = new Select(privacyDropDown);
        privacyField.selectByVisibleText (privacy);
    }

    private void selectAccess(String field){
        Select accessField = new Select(accessDropDown);
        accessField.selectByVisibleText(field);
    }

    private void selectCategory(String category){
        Select categoryField = new Select(categoryDropDown);
        categoryField.selectByVisibleText(category);
    }


}
