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

	private Resources resources;


	public ResourceStepDefs(SharedDriver sharedDriver, Home home,Resources resources) {
		this.home = home;
		this.resources = resources;
	}

	//  resources
	@And("I create a Question Bank Resource with:")
	public void iCreateAQuestionBankResourceWith(Map<String, String> datatable) {
		resources = home.clickResourceMenu("Resources");
		CreateQuestionBankPopup createResourceQuestionPopup = resources.clickCreateQuestionBankButton();
		createResourceQuestionPopup.CreateQuestionBank(datatable);

	}
	@When("I delete the Question Bank Resource {string}")
	public void iDeleteTheQuestionBankResource(String Name) {
		resources.clickDeleteQuestionBankButton(Name);

	}

	@And("I should not find {string} item")
	public void iShouldNotFindItem(String Name) {
		Assert.assertEquals(false, resources.existResourceQuestionByName(Name));

	}


}
