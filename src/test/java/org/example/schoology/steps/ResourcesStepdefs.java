package org.example.schoology.steps;

import io.cucumber.java.en.And;
import org.example.SharedDriver;
import org.example.schoology.pages.QuestionBankPopup;
import org.example.schoology.pages.Resources;
import org.example.schoology.pages.Home;

import java.util.HashMap;
import java.util.Map;

public class ResourcesStepdefs {

    private Resources resources;
    String resourceName = "";

    public ResourcesStepdefs(SharedDriver sharedDriver, Resources  resources) {
        this.resources = resources;
    }
    @And("I create a resource with:")
    public void iCreateAResourceWith(Map<String, String> datatable) {
        resources.clickAddResourcesComboBox();
        QuestionBankPopup questionBankPopup = resources.selectAddQuestionBankOption();

        resourceName = "Test Resources";
        Map<String, String> resourceMap = new HashMap<>();
        resourceMap.put("name", resourceName);
        resourceMap.put("description", "Description");
        resourceMap.put("enableQuestionTracking", "True");
        resources = questionBankPopup.addQuestionBank(resourceMap);
    }

    @And("I delete the question bank with name {string}")
    public void iDeleteTheQuestionBankWithName(String arg0) {
        resources.deleteResource(resourceName);
    }
}
