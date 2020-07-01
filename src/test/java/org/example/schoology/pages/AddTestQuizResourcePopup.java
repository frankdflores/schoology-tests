package org.example.schoology.pages;

import java.util.Map;

public class AddTestQuizResourcePopup extends AbstractResourcePopup {

    public AddTestQuizResourcePopup() {
        super();
    }

    public EditAssessmentQuestions AddResource(Map<String, String> resourceMap) {
        fillAddTestQuizForm(resourceMap);
        addTestQuizSubmitButton.click();
        return new EditAssessmentQuestions();
    }
}

