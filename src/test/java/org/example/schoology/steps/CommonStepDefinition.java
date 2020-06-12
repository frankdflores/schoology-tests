package org.example.schoology.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.schoology.pages.*;
import org.junit.Assert;

public class CommonStepDefinition extends AbstractPageStepDefinition {

    private Login login = getLogin();
    private Home home = getHome();
    private Courses courses = getCourses();
    private SubMenu subMenu = getSubmenu();
    private CreateCoursePopup createCoursePopup = getCreateCoursePopup();
    private CoursePage coursePage = getCoursePage();
    private EditCoursePopup editCoursePopup = getEditCoursePopup();

    @Given("I log in as {string} user")
    public void iLogInAsUser(String account) {
        //login = new Login();
        home = login.loginAs("LYNX_LEXX@hotmail.com", "TheTop86!");
    }

    @Then("I should see the {string} message")
    public void iShouldSeeTheMessage(String message) {
        Assert.assertEquals(message, courses.getMessage());
    }
}
