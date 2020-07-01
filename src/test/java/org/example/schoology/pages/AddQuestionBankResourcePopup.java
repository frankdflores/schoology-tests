package org.example.schoology.pages;

import java.util.Map;

public class AddQuestionBankResourcePopup extends AbstractResourcePopup {

    public AddQuestionBankResourcePopup() {
        super();
    }

    public Resources AddResource(Map<String, String> resourceMap) {
        fillAddQuestionBankForm(resourceMap);
        addQuestionBankSubmitButton.click();
        return new Resources();
    }

}
