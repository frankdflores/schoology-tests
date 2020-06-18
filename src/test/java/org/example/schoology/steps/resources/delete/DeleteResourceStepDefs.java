package org.example.schoology.steps.resources.delete;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.resources.AddQuestionBankPopup;
import org.example.schoology.pages.resources.Resources;

import java.util.Map;

public class DeleteResourceStepDefs {

    private Home home;

    public DeleteResourceStepDefs(Home home) {
        this.home = home;
    }

    @And("I add the resource {string} with:")
    public void iAddTheResourceWith(String resourceName, Map<String, String> resourceValueMap) {
        Resources resources = home.clickResources();
        resources.clickAddResources();
        AddQuestionBankPopup questionBankPopup = resources.selectAddResourceOption("question-bank");
        questionBankPopup.create(resourceValueMap);
    }

    @When("I delete the resource {string}")
    public void iDeleteTheResource(String resourceName) {
        Resources resources = home.clickResources();
        resources.clickOnResourceActions("My Question Bank");
        resources.deleteAction();
    }
}
