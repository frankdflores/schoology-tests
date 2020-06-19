package org.example.schoology.steps.resources.delete;

import io.cucumber.java.en.When;
import org.example.SharedDriver;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.resources.EditFolderPopup;
import org.example.schoology.pages.resources.Resources;

import java.util.Map;

public class EditResourceStepDefs {

    private Home home;

    public EditResourceStepDefs(SharedDriver sharedDriver, Home home) {
        this.home = home;
    }

    @When("I edit the resource {string} with:")
    public void iEditResourceOptionOf(String resourceName, Map<String, String> resourceEditValueMap) {
        Resources resources = home.clickResources();
        resources.clickOnResourceActions(resourceName);
        EditFolderPopup editFolder = resources.editAction();
        editFolder.edit(resourceEditValueMap);
    }
}
