package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class EditGroupPopup {

    private WebDriver driver;

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
    private  WebElement submitButton;

    private WebDriverWait wait;

    public EditGroupPopup(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public Groups edit(Map<String, String> editGroupMap){
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("newname", () -> setName(editGroupMap.get("newname")));
        stepsMap.put("newdescription", () ->setDescription(editGroupMap.get("newdescription")));
        stepsMap.put("newgroupcode", () ->setGroupCode(editGroupMap.get("newgroupcode")));
        stepsMap.put("newprivacy", () ->selectPrivacy(editGroupMap.get("newprivacy")));
        stepsMap.put("newaccess", () ->selectAccess(editGroupMap.get("newaccess")));
        stepsMap.put("newcategory", () ->selectCategory(editGroupMap.get("newcategory")));


        for(String keyField: editGroupMap.keySet()){
            stepsMap.get(keyField).execute();
        }

        submitButton.click();
        return new Groups(driver);
    }

    public void setName(String name){
        WebElement groupField = groupNameTextField;
        groupField.clear();
        groupField.sendKeys(name);
    }

    public void setDescription(String description){
        WebElement descriptionField = descriptionTextField;
        descriptionField.clear();
        descriptionField.sendKeys(description);
    }

    public void setGroupCode(String groupcode){
        groupCodeTextField.sendKeys(groupcode);
    }

    public void selectPrivacy(String privacy){
        Select privacyField = new Select(privacyDropDown);
        privacyField.selectByVisibleText (privacy);
    }

    public void selectAccess(String field){
        Select accessField = new Select(accessDropDown);
        accessField.selectByVisibleText(field);
    }

    public void selectCategory(String category){
        Select categoryField = new Select(categoryDropDown);
        categoryField.selectByVisibleText(category);
    }


}

