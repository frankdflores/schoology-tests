package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;

import java.util.Map;

public class AddQuestionBankPopup extends AbstractAddQuestionBankPopup {

    public AddQuestionBankPopup(WebDriver driver) {
        super(driver);
    }

    public Resources create(Map<String, String> addQuestionBankMap){
        fill(addQuestionBankMap);
        submitButton.click();
        return new Resources(driver);
    }
}
