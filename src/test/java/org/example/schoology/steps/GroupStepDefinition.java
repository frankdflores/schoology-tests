package org.example.schoology.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.schoology.pages.*;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class GroupStepDefinition {

    private SubMenu subMenu;

    private Home home;

    private Groups groups;

    @And("I create a group with:")
    public void iCreateAGroupWith(Map <String, String> datatable) {
        subMenu = home.clickMenu("Groups");
        Groups groups = subMenu.clickMyGroupsLink();
        CreateGroupPopup createGroupPopup = groups.clickCreateGroupButton();
        GroupPage groupPage = createGroupPopup.create(datatable);
    }

    @When("I navigate to Groups")
    public void iNavigateToGroups() {
        subMenu = home.clickMenu("Groups");
        groups = subMenu.clickMyGroupsLink();
    }

    @And("I edit the {string} group with:")
    public void iEditTheGroupWith(String groupName, Map <String, String> datatable) {
        EditGroupPopup editGroupPopup = groups.clickEditGroup(groupName);
        groups = editGroupPopup.edit(datatable);
    }

    @Then("I should see {string} message")
    public void iShouldSeeMessage(String groupName) {
        Assert.assertEquals(groupName + " has been saved.", groups.getMessage());
    }
}
