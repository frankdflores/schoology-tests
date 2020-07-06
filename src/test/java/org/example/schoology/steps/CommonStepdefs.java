package org.example.schoology.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.core.Environment;
import org.example.core.ui.SharedDriver;
import org.example.schoology.pages.*;
import org.example.schoology.pages.resources.AddQuestionPopup;
import org.example.schoology.pages.resources.Resources;
import org.junit.Assert;

public class CommonStepdefs {

    private Home home;

    private SubMenu subMenu;

    private Resources resources;
    private AddQuestionPopup addQuestionPopup;

    public CommonStepdefs(SharedDriver sharedDriver){

    }

    @Given("I log in as {string} user")
    public void iLogInAsUser(String account) {
        Login login = new Login();
        home = login.loginAs(Environment.getInstance().getValue(String.format("credentials.%s.username", account)),
                Environment.getInstance().getValue(String.format("credentials.%s.password", account)));
    }


    @When("I navigate to {string}")
    public void iNavigateToCoursesGroups(String menu) {
        subMenu = home.clickMenu(menu);
        subMenu.clickViewListLink(menu);
    }

    @Then("I should see the {string} message")
    public void iShouldSeeTheMessage(String message) {
        Assert.assertEquals(message, new ViewList().getMessage());
    }
}


