package org.example.schoology.pages;

import java.util.Map;

public class AddResourcePopup extends AbstractResourcePopup {

    public AddResourcePopup() {
        super();
    }

    public Resources AddResource(Map<String, String> resourceMap) {
        fill(resourceMap);
        submitButton.click();
        return new Resources();
    }

}
