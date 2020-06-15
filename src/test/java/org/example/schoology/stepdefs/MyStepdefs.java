package org.example.schoology.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.schoology.SharedDriver;
import org.example.schoology.pages.CoursePage;
import org.example.schoology.pages.Courses;
import org.example.schoology.pages.CreateCoursePopup;
import org.example.schoology.pages.CreateGroupPopup;
import org.example.schoology.pages.CreateQuestionBankPopup;
import org.example.schoology.pages.DeleteQuestionBank;
import org.example.schoology.pages.EditCoursePopup;
import org.example.schoology.pages.EditGroupPopup;
import org.example.schoology.pages.GroupPage;
import org.example.schoology.pages.Groups;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.Resources;
import org.example.schoology.pages.SubMenu;
import org.junit.Assert;

import java.util.Map;

public class MyStepdefs {

    private Home home;

    private SubMenu subMenu;

    private Courses courses;

    private Groups groups;

    private Resources resources;

    private MyStepdefs(SharedDriver sharedDriver){

    }

    @Given("I log in as {string} user")
    public void iLogInAsUser(String account) {
        Login login = new Login();
        home = login.loginAs("jacky.rosales84@gmail.com", "Control123");
    }

    @And("I create a course with:")
    public void iCreateACourseWith(Map<String, String> datatable) {
        subMenu = home.clickMenu("Courses");
        courses = subMenu.clickMyCoursesLink();
        CreateCoursePopup createCoursePopup = courses.clickCreateCourseBtn();
        CoursePage course = createCoursePopup.create(datatable);
    }

    @And("I create a group with:")
    public void iCreateAGroupWith(Map<String, String> datatable) {
        subMenu = home.clickMenu("Groups");
        groups = subMenu.clickMyGroupsLink();
        CreateGroupPopup createGroupPopup = groups.clickCreateGroupBtn();
        GroupPage group = createGroupPopup.create(datatable);
    }

    @And("I create a resource with:")
    public void iCreateAResourceWith(Map<String, String> dataTable) {
        resources = home.clickMenuResources("Resources");
        CreateQuestionBankPopup createQuestionBankPopup = resources.clickAddResourcesBtn("Add Question Bank");
        resources = createQuestionBankPopup.create(dataTable);
        resources.waitForMessageContainerDisappear();
    }
    @When("I navigate to menu {string}")
    public void iNavigateToMenu(String menu) {
        switch (menu){
            case "Courses":
            case "Groups":
                home.clickMenu(menu);
                break;
            case "Resources":
                home.clickMenuResources(menu);
                break;
        }
    }

    @And("I edit the {string} course with:")
    public void iEditTheCourseWith(String Name, Map<String, String> datatable) {
        EditCoursePopup editCoursePopup = courses.clickEditCourse(Name);
        courses = editCoursePopup.edit(datatable);
    }

    @And("I edit the {string} group with:")
    public void iEditTheGroupWith(String Name, Map<String, String> datatable) {
        EditGroupPopup editGroupPopup = groups.clickEditGroup(Name);
        editGroupPopup.edit(datatable);
    }
    @And("I delete the {string} resource")
    public void iDeleteTheResource(String questionName) {
        DeleteQuestionBank deleteQuestionBank = resources.clickDeleteQuestion(questionName);
        resources = deleteQuestionBank.delete();
    }

    @Then("I should see the {string} message")
    public void iShouldSeeTheMessage(String message) {
        Assert.assertEquals(message, resources.getMessage());
        resources.waitForMessageContainerDisappear();
    }

    @And("I should see the {string} section on {string} course item")
    public void iShouldSeeTheSectionOnCourseItem(String expectedSection, String courseName) {
        Assert.assertEquals(expectedSection, courses.getSectionByName(courseName));
    }

    @And("I should see a group with {string} as a name")
    public void iShouldSeeAGroupWithAsName(String groupName) {
        Assert.assertEquals(groupName, groups.getGroupByName(groupName));

    }

    @And("I should not see the resource deleted {string}")
    public void iShouldNotSeeTheResourceDeleted(String questionName) {
        boolean bool = resources.getResourceByName(questionName);
        Assert.assertFalse(bool);
    }


}
