package org.example.schoology.pages.resources;

import java.util.Map;

public class AddQuestionPopup extends AbstractQuestionPopup {

    public Resources create(Map<String, String> questionMap) {
        fill(questionMap);
        trackingCheck.click();
        submitButton.click();
        return new Resources();
    }
}