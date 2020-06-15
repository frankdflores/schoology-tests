package org.example.schoology.pages;

import java.util.Map;

public class AddQuestionBankPopup extends AbstractAddQuestionBankPopup {


    public Resources create(Map<String, String> addQuestionBankMap){
        fill(addQuestionBankMap);
        submitButton.click();
        return new Resources();
    }
}
