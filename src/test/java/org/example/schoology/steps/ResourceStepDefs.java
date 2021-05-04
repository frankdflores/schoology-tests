package org.example.schoology.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.core.AssertionGroup;
import org.example.core.Environment;
import org.example.core.ScenarioContext;
import org.example.schoology.Resources;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.resources.CreatePageResourcePopup;
import org.example.schoology.pages.resources.PageResourceForm;
import org.example.schoology.pages.resources.ResourcesPage;
import org.testng.asserts.Assertion;

import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author Veronica Prado
 */
public class ResourceStepDefs {
    private final ScenarioContext context;
    private final Home home;
    private ResourcesPage pageResources;
    private ResourceBundle bundle;
    private final Assertion assertion;
    public ResourceStepDefs(final AssertionGroup assertionGroup, final ScenarioContext context, final ResourcesPage resources) {
        assertion = assertionGroup.getAssertion();
        this.context = context;
        this.home = new Home();
        this.pageResources = resources;
        bundle=ResourceBundle.getBundle(Resources.I18N_RESOURCE,
                Environment.getInstance().getLocale());
    }

    @And("I add a page resource with:")
    public void iAddAResourcePageWith(final Map<PageResourceForm, String> datatable){
        final String keyResources = "resources";
        final String keyAddPage = "resource.addPage";
        String addResourceNameOption = bundle.getString(keyAddPage);
        home.clickMenu(keyResources);
        pageResources.clickAddResourcesButton();
        CreatePageResourcePopup createPage =  pageResources.selectAddResourceOption(addResourceNameOption);
        createPage.create(datatable);
    }

    @When("I edit the {string} Page Resource with:")
    public void idEditPageResource(final String resource, final Map<PageResourceForm, String> datatable)
    {
        pageResources.editResource(resource);
        CreatePageResourcePopup createPage =  pageResources.editResource(resource);
        createPage.create(datatable);
    }


    @Then("I should see the {string} resource message")
    public void iShouldSeeTheResourceMessage(final String message) {
        String messageResource = bundle.getString("resource.AddResource.Message");
        assertion.assertEquals(pageResources.getMessage(), messageResource);
    }
}
