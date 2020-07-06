package org.example.schoology.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.core.ui.SharedDriver;
import org.example.schoology.pages.*;
import org.example.schoology.pages.courses.Courses;
import org.example.schoology.pages.groups.Groups;
import org.example.schoology.pages.resources.AddQuestionPopup;
import org.example.schoology.pages.resources.Resources;
import org.junit.Assert;

import java.util.Map;

public class ResourceStepDefs {

    private SubMenu subMenu;

    private Courses courses;

    private Groups groups;

    private Resources resources;
    private AddQuestionPopup addQuestionPopup;

    public ResourceStepDefs(SharedDriver sharedDriver){

    }

    @And("I create a resource with:")
    public void iCreateAResourceWith(Map<String, String> datatable) {
        resources = new Home().clickResourcesMenu("Resources");
        addQuestionPopup = resources.clickAddResources();
        resources = addQuestionPopup.create(datatable);
    }

    @When("I delete the {string} resource")
    public void iDeleteTheResource(String resourceName) {
        resources.clickDeleteResource(resourceName);
    }

    @And("I should not see the {string} displayed")
    public void iShouldNotSeeTheDisplayed(String resourceName) {
        Assert.assertEquals(false, resources.getResourceByName(resourceName));
    }
}


