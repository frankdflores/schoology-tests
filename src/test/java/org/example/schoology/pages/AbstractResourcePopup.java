package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.HashMap;
import java.util.Map;

public abstract class AbstractResourcePopup extends AbstractPage {

    @FindBy(css = "#edit-title")
    private WebElement questionBankNameTextField;

    @FindBy(css = "#edit-description")
    private WebElement questionBankDescriptionTextField;

    @FindBy(css = "#edit-enable-tracking")
    private WebElement questionBankEnableTrackingCheckBox;

    @FindBy(css = "input[value='Create'")
    protected  WebElement submitButton;

    public void setName(String name) {
        questionBankNameTextField.sendKeys(name);
    }

    public void setDescription(String description) {
        questionBankDescriptionTextField.sendKeys(description);
    }

    public void fill(Map<String, String> resourceMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setName(resourceMap.get("name")));
        stepsMap.put("description", () -> setDescription(resourceMap.get("description")));
        stepsMap.put("enableQuestionTracking", () -> setEnableQuestionTracking(resourceMap.get("enableQuestionTracking")));

        for (String keyField : resourceMap.keySet()) {
            stepsMap.get(keyField).execute();
        }
    }

    private void setEnableQuestionTracking(String enableQuestionTracking) {
        switch(enableQuestionTracking) {
            case "True":
                questionBankEnableTrackingCheckBox.click();
                break;
        }
    }
}
