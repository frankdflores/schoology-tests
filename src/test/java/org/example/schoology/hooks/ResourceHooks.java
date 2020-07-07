package org.example.schoology.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.core.ScenarioContext;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Resources;
import org.example.schoology.pages.resources.DeleteResourcePopup;

public class ResourceHooks {

    private ScenarioContext context;
    private Home home;
    private Resources resources;

    public ResourceHooks(final ScenarioContext context) {
        this.context = context;
    }

    @Before
    public void beforeScenario() {
        // this will be executed in all the scenarios

    }


    @After(value = "@deleteResource")
    public void deleteResource() {
        home.clickResourcesMenuOption();
        DeleteResourcePopup deleteResourcePopup = resources.clickRemoveResource(context.getValue("ResourceNameKey"));
        deleteResourcePopup.clickDeleteButton();
    }
}
