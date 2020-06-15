package org.example.schoology.pages;

import java.util.Map;

public class CreateQuestionBankPopup extends AbstractResourcePopup{

    public Resources create(Map<String, String> questionMap) {
        fill(questionMap);
        submitButton.click();
        return new Resources() ;
    }

}
