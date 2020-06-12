import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.schoology.pages.CreateQuestionBankPopup;
import org.example.schoology.pages.DeleteQuestionBank;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.Resources;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class MyStepdefs {

    private Home home;
    private Resources resourcesPage;

    @Given("I log in as {string} user")
    public void iLogInAsUser(String account) {
        Login login = new Login();
         home = login.loginAs("jacky.rosales84@gmail.com", "Control123");
    }

    @And("I create a resource with:")
    public void iCreateAResourceWith(Map<String, String> dataTable) {
        resourcesPage = home.clickMenuResources("Resources");
        CreateQuestionBankPopup createQuestionBankPopup = resourcesPage.clickAddResourcesBtn("Add Question Bank");

        resourcesPage = createQuestionBankPopup.create(dataTable);
        resourcesPage.waitForMessageContainerDisappear();
    }

    @When("I navigate to Resources")
    public void iNavigateToResources() {
        resourcesPage = home.clickMenuResources("Resources");
    }

    @And("I delete the {string} resource")
    public void iDeleteTheResource(String questionName) {
        DeleteQuestionBank deleteQuestionBank = resourcesPage.clickDeleteQuestion(questionName);
        resourcesPage = deleteQuestionBank.delete();
    }

    @Then("I should see the {string} message")
    public void iShouldSeeTheMessage(String message) {
        Assert.assertEquals(message, resourcesPage.getMessage());
        resourcesPage.waitForMessageContainerDisappear();
    }

    @And("I should not see the resource deleted {string}")
    public void iShouldNotSeeTheResourceDeleted(String questionName) {
        boolean bool = resourcesPage.getResourceByName(questionName);
        Assert.assertFalse(bool);
    }

}
