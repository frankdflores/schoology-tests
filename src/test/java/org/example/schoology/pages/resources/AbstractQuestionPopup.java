package org.example.schoology.pages.resources;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class AbstractQuestionPopup extends AbstractPage {

    @FindBy(css="#edit-title")
    private WebElement groupNameTextField;

    @FindBy(css="#edit-description")
    private WebElement descriptionTextField;

    @FindBy(css="#edit-enable-tracking")
    protected WebElement trackingCheck;

    @FindBy(css="input[value='Create']")
    protected WebElement submitButton;

    public void fill(Map<String, String> questionMap){
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setName(questionMap.get("name")));
        stepsMap.put("description", () ->setDescription(questionMap.get("description")));

        for(String keyField: questionMap.keySet()){
            stepsMap.get(keyField).execute();
        }
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#feed-empty-message")));
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

}
