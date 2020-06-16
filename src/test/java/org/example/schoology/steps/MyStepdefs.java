package org.example.schoology.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.SharedDriver;
import org.example.schoology.pages.*;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class MyStepdefs {

    private Home home;

    private SubMenu subMenu;

    private Courses courses;

    private Groups groups;

    private Resources resources;
    private AddQuestionPopup addQuestionPopup;

    public MyStepdefs(SharedDriver sharedDriver){

    }



    @Given("I log in as {string} user")
    public void iLogInAsUser(String account) {
        Login login = new Login();
        home = login.loginAs("magnethus01@gmail.com", "TheTop86!");
    }

    @And("I create a {string} with:")
    public void iCreateACourseGroupWith(String courseGroupsResources, Map<String, String> datatable) {
        switch(courseGroupsResources){
            case "course":
                subMenu = home.clickMenu("Courses");
                courses = subMenu.clickMyCoursesLink();
                CreateCoursePopup createCoursePopup = courses.clickCreateCourseButton();
                CoursePage coursePage = createCoursePopup.create(datatable);
                break;
            case "group":
                subMenu = home.clickMenu("Groups");
                groups = subMenu.clickMyGroupsLink();
                CreateGroupPopup createGroupPopup = groups.clickCreateGroupButton();
                GroupPage groupPage = createGroupPopup.create(datatable);
                break;
            case "resource":
                resources = home.clickResourcesMenu("Resources");
                addQuestionPopup = resources.clickAddResources();
                resources = addQuestionPopup.create(datatable);
        }
    }


    @When("I navigate to {string}")
    public void iNavigateToCoursesGroups(String courseGroupsResources) {
        subMenu = home.clickMenu(courseGroupsResources);
        if (courseGroupsResources.equals("Courses")){
            courses = subMenu.clickMyCoursesLink();
        }else{
            groups = subMenu.clickMyGroupsLink();
        }
    }

    @And("I edit the {string} {string} with:")
    public void iEditTheCourseGroupWith(String name, String courseGroupsResources, Map<String, String> datatable) {
        if (courseGroupsResources.equals("course")){
            EditCoursePopup editCoursePopup = courses.clickEditCourse(name);
            //String courseNameEdited = "EditedName";
            courses = editCoursePopup.edit(datatable);
        }else{
            EditGroupPopup editGroupPopup = groups.clickEditGroup(name);
            groups = editGroupPopup.edit(datatable);
        }
    }

    @Then("I should see the {string} message")
    public void iShouldSeeTheMessage(String message) {
        Assert.assertEquals(message, courses.getMessage());
    }

    @Then("I should see {string} message")
    public void iShouldSeeMessage(String message) {
        Assert.assertEquals(message, groups.getMessage());
    }

    @Then("I should see {string} message description")
    public void iShouldSeeMessageDescription(String message) {
        Assert.assertEquals(message, resources.getMessage());
    }

    @And("I should see the {string} section on {string} course item")
    public void iShouldSeeTheSectionOnCourseItem(String expectedSection, String courseName) {
        Assert.assertEquals(expectedSection, courses.getSectionByName(courseName));
    }

    @And("I should see the {string} group name")
    public void iShouldSeeTheGroupName(String groupName) {
        Assert.assertEquals(groupName, groups.getGroupByName(groupName));
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


