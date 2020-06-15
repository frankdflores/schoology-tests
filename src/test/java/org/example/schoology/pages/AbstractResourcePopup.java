package org.example.schoology.pages;

import org.example.schoology.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class AbstractResourcePopup extends AbstractPage {

    @FindBy(css = "#edit-title")
    private WebElement questionNameTextField;

    @FindBy(css = "#edit-description")
    private WebElement questionDescriptionTextField;

    @FindBy(css = "#edit-enable-tracking")
    private WebElement enableTracking;

    @FindBy(css = "input[id='edit-submit'][value='Create']")
    protected WebElement submitButton;

    public void fill(Map<String, String> questionMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setName(questionMap.get("name")));
        stepsMap.put("description", () -> setDescription(questionMap.get("description")));
        stepsMap.put("enableTracking" , () -> checkTrackingBox(questionMap.get("enableTracking")));

        for (String keyField : questionMap.keySet()) {
            stepsMap.get(keyField).execute();
        }

    }

    private void setName(String name) {
        questionNameTextField.sendKeys(name);
    }

    private void setDescription(String description) {
        questionDescriptionTextField.sendKeys(description);
    }

    private void checkTrackingBox(String value) {
        if (value.equals("True")) {
            enableTracking.click();
        }
    }

}
