package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class AddQuestionPopup extends AbstractQuestionPopup {

    public Resources create(Map<String, String> questionMap) {
        fill(questionMap);
        trackingCheck.click();
        submitButton.click();
        return new Resources();
    }
}