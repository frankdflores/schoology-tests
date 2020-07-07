package org.example.schoology.pages.resources;

import org.example.schoology.pages.EditAssessmentQuestions;

import java.util.Map;

public class AddTestQuizResourcePopup extends AbstractResourcePopup {

    public AddTestQuizResourcePopup() {
        super();
    }

    public EditAssessmentQuestions addResource(final Map<String, String> resourceMap) {
        fillAddTestQuizForm(resourceMap);
        action.click(addTestQuizSubmitButton);
        return new EditAssessmentQuestions();
    }
}

