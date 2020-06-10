package org.example.schoology.pages.resources;

import org.example.schoology.pages.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class AddQuestionBankResourcePopup extends AddResourcePopupAbstract {

    @FindBy(css = "#edit-title")
    private WebElement resourceNameTextField;

    @FindBy(css = "#edit-description")
    private WebElement descriptionTextArea;

    @FindBy(css = "#edit-enable-tracking" )
    private WebElement enableQuestionTrackingCheckBox;

    public AddQuestionBankResourcePopup(WebDriver driver) {
        super(driver);
    }

    private void setName(final String name) {
        resourceNameTextField.sendKeys(name);
    }

    private void setDescription(final String description) {
        descriptionTextArea.sendKeys(description);
    }


    private void enableQuestionTracking(final boolean enableQuestionTracking) {
        if (enableQuestionTracking != enableQuestionTrackingCheckBox.isSelected()) {
            enableQuestionTrackingCheckBox.click();
        }
    }

    @Override
    public MyResources addResource(final Map<String, String> resourceMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setName(resourceMap.get("name")));
        stepsMap.put("description", () -> setDescription(resourceMap.get("description")));
        stepsMap.put("enable question tracking", () -> enableQuestionTracking(resourceMap
                .get("enable question tracking").equalsIgnoreCase("yes")));

        for (String keyField : resourceMap.keySet()) {
            stepsMap.get(keyField).execute();
        }
        submitButton.click();
        return new MyResources(driver);
    }

}
