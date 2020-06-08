package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class CreateGroupPopup {
    WebDriver driver;

    @FindBy(css = "#edit-name")
    WebElement groupNameTextField;

    @FindBy(css = "#edit-description")
    WebElement descriptionTextArea;

    @FindBy(css = "#edit-privacy-level")
    WebElement editPrivacyLevel;

    @FindBy(css = "#edit-invite-type")
    WebElement editAccessType;

    @FindBy(css = "#edit-category")
    WebElement editCategory;

    @FindBy(css = "#edit-submit")
    WebElement createGroupButton;

    public CreateGroupPopup(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void create(Map<String, String> groupName){

        Map<String, Step> stepsMap = new HashMap<>();

        stepsMap.put("name", () -> setName(groupName.get("name")));
        stepsMap.put("description", () -> setDescription(groupName.get("description")));
        stepsMap.put("privacyLevel", () -> selectPrivacyLevel(groupName.get("privacyLevel")));
        stepsMap.put("accessType", () -> selectAccessType(groupName.get("accessType")));
        stepsMap.put("category", () -> selectCategory(groupName.get("category")));

        for(String keyField : groupName.keySet()){
            stepsMap.get(keyField).execute();
        }

        createGroupButton.click();
//        return new CoursePage(driver);

    }

    public void setName(String name){
        groupNameTextField.sendKeys(name);
    }

    public void setDescription(String description){
        WebElement descriptionField = descriptionTextArea;
        descriptionTextArea.sendKeys(description);
    }

    public void selectPrivacyLevel(String privacyLevel){
        Select privacyLevelDropDown = new Select(editPrivacyLevel);
        privacyLevelDropDown.selectByVisibleText(privacyLevel);
    }

    public void selectAccessType(String accessType){
        Select editAccessTypeDropDown = new Select(editAccessType);
        editAccessTypeDropDown.selectByVisibleText(accessType);
    }

    public void selectCategory(String category){
        Select categoryDropDown = new Select(editCategory);
        categoryDropDown.selectByVisibleText(category);
    }
}
