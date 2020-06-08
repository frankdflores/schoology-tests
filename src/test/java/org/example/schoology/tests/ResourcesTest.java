package org.example.schoology.tests;

import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.QuestionBankPopup;
import org.example.schoology.pages.Resources;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ResourcesTest {
    @Test
    public void deleteQuestionBankResource() {
        Login login = new Login();
        Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
        Resources resources = home.clickResources();
        resources.clickAddResourcesComboBox();
        QuestionBankPopup questionBankPopup = resources.selectAddQuestionBankOption();

        String resourceName = "Test Resources";
        Map<String, String> resourceMap = new HashMap<>();
        resourceMap.put("name", resourceName);
        resourceMap.put("description", "Description");
        resourceMap.put("enableQuestionTracking", "True");
        resources = questionBankPopup.addQuestionBank(resourceMap);

        resources.deleteResource(resourceName);

        Assert.assertEquals("Your item has been removed.", resources.getMessage());

        Assert.assertFalse(resources.searchResourceByName(resourceName));
    }
}
