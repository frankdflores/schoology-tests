package org.example.schoology.steps;

import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.SharedDriver;
import org.example.schoology.pages.*;
import org.junit.Assert;

public class ResourceStepDefs {

    private Home home;
    private SubMenu subMenu;
    private Resources resources;
    private EditAssessmentQuestions editAssessmentQuestions;
    private MultipleChoiceQuestion multipleChoiceQuestion;

    public ResourceStepDefs(SharedDriver sharedDriver, Resources resources, Home home) {
        this.home = home;
        this.resources = resources;
    }

   @And("I create an Add Question Bank resource with:")
    public void iCreateAResourceWith(Map<String, String> datatable) {
        resources = home.clickResourcesMenuOption();
        AddQuestionBankResourcePopup addQuestionBankResourcePopup = resources.clickAddQuestionBankResource();
        resources = addQuestionBankResourcePopup.AddResource(datatable);
    }

    @And("I should not see a resource with name {string}")
    public void iShouldNotSeeAResourceWithName(String name) {
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

    @And("I create an Add Test Quiz resource with:")
    public void iCreateAnAddTestQuizResourceWith(Map<String, String> datatable) {
        resources = home.clickResourcesMenuOption();
        AddTestQuizResourcePopup addTestQuizResourcePopup = resources.clickAddTestQuizResource();
        editAssessmentQuestions = addTestQuizResourcePopup.AddResource(datatable);
    }

    @And("I added a multiple choice question with:")
    public void iAddedAMultipleChoiceQuestionWith(Map<String, String> datatable) {
        multipleChoiceQuestion = editAssessmentQuestions.clickAddQuestionMultipleChoice();
        multipleChoiceQuestion.addMultipleChoiceQuestion(datatable);
    }


    @Then("I should see a resource with name {string}")
    public void iShouldSeeAResourceWithName(String resourceName) {
        Assert.assertTrue(resources.resourceItemExist(resourceName));
    }

    @Then("I comeback to resources page")
    public void iComebackToResourcesPage() {
        multipleChoiceQuestion.backToResourcesPage();
    }

    @And("resource {string} has the question {string}")
    public void resourceHasTheQuestion(String resourceName, String questionName) {
        resources.clickEditQuestionsQuizResource(resourceName);
        Assert.assertTrue(editAssessmentQuestions.questionItemExist(questionName));

    }
}

