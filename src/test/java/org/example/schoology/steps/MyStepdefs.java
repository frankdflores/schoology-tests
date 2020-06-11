package org.example.schoology.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.schoology.pages.*;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class MyStepdefs {

    private Home home;

    private SubMenu subMenu;

    private Courses courses;

    @Given("I log in as {string} user")
    public void iLogInAsUser(String account) {
        Login login = new Login();
        home = login.loginAs("LYNX_LEXX@hotmail.com", "TheTop86!");
    }

    @And("I create a course with:")
    public void iCreateACourseWith(Map<String, String> datatable) {
        subMenu = home.clickMenu("Courses");
        courses = subMenu.clickMyCoursesLink();
        CreateCoursePopup createCoursePopup = courses.clickCreateCourseButton();
        //Course course = new Course();

        CoursePage coursePage = createCoursePopup.create(datatable);

    }

    @When("I navigate to Courses")
    public void iNavigateToCourses() {
        subMenu = home.clickMenu("Courses");
        courses = subMenu.clickMyCoursesLink();
    }

    @And("I edit the {string} course with:")
    public void iEditTheCourseWith(String courseName, Map<String, String> datatable) {
        EditCoursePopup editCoursePopup = courses.clickEditCourse(courseName);
        String courseNameEdited = "EditedName";
        courses = editCoursePopup.edit(datatable);
    }

    @Then("I should see the {string} message")
    public void iShouldSeeTheMessage(String message) {
        Assert.assertEquals(message, courses.getMessage());
    }

    @And("I should see the {string} section on {string} course item")
    public void iShouldSeeTheSectionOnCourseItem(String expectedSection, String courseName) {
        Assert.assertEquals(expectedSection, courses.getSectionByName(courseName));
    }
}
