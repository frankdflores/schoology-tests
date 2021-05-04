package org.example.schoology.pages.resources;

import java.util.Map;

/**
 * @author Veronica Prado
 */
public class CreatePageResourcePopup extends AbstractPageResourcePopup {


    public Resource create(final Map<PageResourceForm, String> resourceMap) {
        action.scrollTo(OptionsButton());
        OptionsButton().click();
        fill(resourceMap);
        submitButton();
        return new Resource();

    }

}
