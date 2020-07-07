package org.example.schoology.pages.resources;

import org.example.schoology.pages.Resources;

import java.util.Map;

public class AddQuestionBankResourcePopup extends AbstractResourcePopup {

    public AddQuestionBankResourcePopup() {
        super();
    }

    public Resources addResource(final Map<String, String> resourceMap) {
        fillAddQuestionBankForm(resourceMap);
        action.click(addQuestionBankSubmitButton);
        return new Resources();
    }

}
