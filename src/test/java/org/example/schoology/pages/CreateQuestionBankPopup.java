package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;

import java.util.Map;

public class CreateQuestionBankPopup extends AbstractResourcePopup{

    public CreateQuestionBankPopup(WebDriver driver) {
        super(driver);
    }

    public Resources create(Map<String, String> questionMap) {
        fill(questionMap);
        submitButton.click();
        return new Resources(driver) ;
    }

}
