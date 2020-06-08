package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;

import java.util.Map;

public class AddQuestionPopup extends AbstractQuestionPopup {

    public AddQuestionPopup(WebDriver driver) {
        super(driver);
    }

    public Resources create(Map<String, String> questionMap) {
        fill(questionMap);
        trackingCheck.click();
        submitButton.click();
        return new Resources(driver);
    }
}