package org.example.schoology.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractGroupPopup {
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

    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractGroupPopup(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    private void setName(String name){
        WebElement groupField = groupNameTextField;
        groupField.clear();
        groupField.sendKeys(name);
    }

    private void setDescription(String description){
        WebElement descriptionField = descriptionTextField;
        descriptionField.clear();
        descriptionField.sendKeys(description);
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

    public void fill(Map<String, String> groupMap){
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setName(groupMap.get("name")));
        stepsMap.put("description", () ->setDescription(groupMap.get("description")));
        stepsMap.put("privacy", () ->selectPrivacy(groupMap.get("privacy")));
        stepsMap.put("access", () ->selectAccess(groupMap.get("access")));
        stepsMap.put("category", () ->selectCategory(groupMap.get("category")));

        for(String keyField: groupMap.keySet()){
            stepsMap.get(keyField).execute();
        }
    }
}
