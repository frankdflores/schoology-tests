package org.example.schoology.steps;

import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.SharedDriver;
import org.example.schoology.pages.*;
import org.junit.Assert;

public class ResourceStepDefs {

    private Home home;

    private SubMenu subMenu;

    private Resources resources;

    public ResourceStepDefs(SharedDriver sharedDriver, Resources resources, Home home) {
        this.home = home;
        this.resources = resources;
    }

   @And("I create a {string} resource with:")
    public void iCreateAResourceWith(String resourceName, Map<String, String> datatable) {
        resources = home.clickResourcesMenuOption();
        AddResourcePopup addResourcePopup = resources.clickAddResource(resourceName);
        resources = addResourcePopup.AddResource(datatable);
    }

    @And("I should not see a resource with {string}")
    public void iShouldNotSeeAResourceWith(String name) {
        Assert.assertFalse(resources.resourceItemExist(name));
    }

    @When("I remove a resource with name {string}")
    public void iRemoveAResourceWithName(String name) {
        DeleteResourcePopup deleteResourcePopup = resources.clickRemoveResource(name);
        resources = deleteResourcePopup.clickDeleteButton();
    }

    @And("I wait for message disappear")
    public void iWaitForMessageDisappear() {
        resources.waitForMessageContainerDisappear();
    }

    @Then("I should see message {string}")
    public void iShouldSeeMessage(String message) {
        Assert.assertEquals(message, resources.getMessage());
    }
}

