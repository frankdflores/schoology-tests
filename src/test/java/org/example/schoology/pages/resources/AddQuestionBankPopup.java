package org.example.schoology.pages.resources;

import org.example.schoology.pages.Step;
import org.example.schoology.pages.ViewList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class AddQuestionBankPopup extends ViewList {

    @FindBy(css = "input#edit-title")
    private WebElement nameTextField;

    @FindBy(css = "textArea#edit-description")
    private WebElement descriptionTextAreaField;

    @FindBy(css = "input#edit-enable-tracking")
    private WebElement enableQuestionTrackingCheckboxField;

    @FindBy(css = "input[id='edit-submit'][value='Create']")
    private WebElement createButtonField;

    public Resources create(Map<String, String> questionBankValuesMap) {
        fillFields(questionBankValuesMap);
        createButtonField.click();

        return new Resources();
    }

    private void fillFields(Map<String, String> questionBankValuesMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setName(questionBankValuesMap.get("name")));
        stepsMap.put("description", () -> setDescription(questionBankValuesMap.get("description")));
        //stepsMap.put("enable question Tracking", () -> setEnableQuestionTracking(questionBankValuesMap.get("enable question Tracking")));

        for (Step step : stepsMap.values()) {
            step.execute();
        }

//        for (String keyField : questionBankValuesMap.keySet()) {
//            stepsMap.get(keyField).execute();
//        }
    }

    public void setName(String name) {
        nameTextField.sendKeys(name);
    }

    public void setDescription(String description) {
        descriptionTextAreaField.sendKeys(description);
    }

    public void setEnableQuestionTracking(String isChecked) {
//        if (!Boolean.valueOf(isChecked).equals(enableQuestionTrackingCheckboxField.isSelected())) {
//            enableQuestionTrackingCheckboxField.click();
//        }
    }
}
