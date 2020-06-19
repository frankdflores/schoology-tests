package org.example.schoology.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.SharedDriver;
import org.example.schoology.pages.*;
import org.testng.Assert;

public class CommonStepDefs {

	private Home home;

	private SubMenu subMenu;

	private Resources resources;

	public CommonStepDefs(SharedDriver sharedDriver) {

	}

	@Given("I log in as {string} user")
	public void iLogInAsUser(String account) {
		Login login = new Login();
		home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
	}

	@When("I navigate to {string}")
	public void iNavigateToCourses(String menu) {
		subMenu = home.clickMenu(menu);
		subMenu.clickViewListLink(menu);
	}

	@Then("I should see the {string} message")
	public void iShouldSeeTheMessage(String message) {
		Assert.assertEquals(message, new ViewList().getMessage());
	}

	@And("I navigate to Resources")
	public void iNavigateToResources() {
		resources = home.clickResources();
	}
}
