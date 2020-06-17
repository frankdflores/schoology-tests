package org.example.schoology.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.SharedDriver;
import org.example.schoology.pages.*;
import org.junit.Assert;

import java.util.Map;

public class GroupStepDefs {


    private SubMenu subMenu;

    private Courses courses;

    private Groups groups;

    private Resources resources;
    private AddQuestionPopup addQuestionPopup;

    public GroupStepDefs(SharedDriver sharedDriver){

    }

    @And("I create a group with:")
    public void iCreateAGroupWith(Map<String, String> datatable) {
        subMenu = new Home().clickMenu("Groups");
        groups = subMenu.clickMyGroupsLink();
        CreateGroupPopup createGroupPopup = groups.clickCreateGroupButton();
        GroupPage groupPage = createGroupPopup.create(datatable);
    }

    @And("I edit the {string} group with:")
    public void iEditTheGroupWith(String name, Map<String, String> datatable) {
            EditGroupPopup editGroupPopup = groups.clickEditGroup(name);
            groups = editGroupPopup.edit(datatable);
    }

    @And("I should see the {string} group name")
    public void iShouldSeeTheGroupName(String groupName) {
        Assert.assertEquals(groupName, groups.getGroupByName(groupName));
    }

}


