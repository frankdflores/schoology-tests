package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;

import java.util.Map;

public class AddResourcePopup extends AbstractResourcePopup {

    public AddResourcePopup(WebDriver driver) {
        super(driver);
    }

    public Resources AddResource(Map<String, String> resourceMap, String enableQuestionTracking) {
        fill(resourceMap, enableQuestionTracking);
        submitButton.click();
        return new Resources(driver);
    }

}
