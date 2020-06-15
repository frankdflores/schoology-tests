package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractAddQuestionBankPopup extends AbstractPage {

    @FindBy (css = "#edit-title")
    private WebElement addQuestionBankNameTextField;

    @FindBy (css = "#edit-description")
    private WebElement descriptionTextField;

    @FindBy (css = "#edit-enable-tracking")
    private WebElement enableQuestionTrackingCheckBox;

    @FindBy(css = "#edit-submit[value=\"Create\"]")
    protected WebElement submitButton;

    private void setName(String name){
        WebElement questionNameField = addQuestionBankNameTextField;
        questionNameField.clear();
        questionNameField.sendKeys(name);
    }

    private void setDescription(String description){
        WebElement descriptionField = descriptionTextField;
        descriptionField.clear();
        descriptionField.sendKeys(description);
    }

    private void enableQuestionTracking(String enable){
        if (enable.equals("true")) {
            enableQuestionTrackingCheckBox.click();
        }
    }

    public void fill(Map<String, String> addQuestionBankMap){
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setName(addQuestionBankMap.get("name")));
        stepsMap.put("description", () ->setDescription(addQuestionBankMap.get("description")));
        stepsMap.put("enable", () -> enableQuestionTracking(addQuestionBankMap.get("enable")));

        for(String keyField: addQuestionBankMap.keySet()){
            stepsMap.get(keyField).execute();
        }
    }
}
