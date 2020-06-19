package org.example.schoology.steps.resources.delete;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.SharedDriver;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.resources.AddQuestionBankPopup;
import org.example.schoology.pages.resources.Resources;

import java.util.Map;

public class DeleteResourceStepDefs {

    private Home home;
    private Resources resources;

    public DeleteResourceStepDefs(SharedDriver sharedDriver, Home home) {
        this.home = home;
    }

    @And("I add the resource Question Bank with:")
    public void iAddTheResourceWith(Map<String, String> resourceValueMap) {
        resources = home.clickResources();
        resources.clickAddResources();
        AddQuestionBankPopup questionBankPopup = resources.selectAddResourceOption("question-bank");
        questionBankPopup.create(resourceValueMap);
    }

    @When("I delete the resource {string}")
    public void iDeleteTheResource(String resourceName) {
        resources.clickOnResourceActions(resourceName);
        resources.deleteAction();
    }
}
