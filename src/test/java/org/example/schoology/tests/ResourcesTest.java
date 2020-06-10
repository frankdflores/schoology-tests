package org.example.schoology.tests;

import org.example.schoology.pages.DeletePopup;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.resources.AddResourcePopupAbstract;
import org.example.schoology.pages.resources.MyResources;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class ResourcesTest {

    private static final String PREFIX_WA_YA = "WA_YA_";

    @Test
    public void deleteQuestionBankResource() {

        // Test Data
        String resourceName = PREFIX_WA_YA + "Test Resource" + System.currentTimeMillis();
        String resourceType = "question bank";
        HashMap<String, String> resourceMap = new HashMap<>();
        resourceMap.put("name", resourceName);
        resourceMap.put("description", "Resource Description");
        resourceMap.put("enable question tracking", "yes");

        // Given
        Login login = new Login();
        Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
        MyResources myResources = home.clickResourcesMenu();
        AddResourcePopupAbstract addResourcePopup = myResources.clickAddResources(resourceType);
        myResources = addResourcePopup.addResource(resourceMap);
        myResources.closeMessage();

        // When
        DeletePopup deletePopup = myResources.deleteResource(resourceName);
        myResources = deletePopup.clickDeleteButton();

        // Then
        Assert.assertEquals("Your item has been removed.", myResources.getMessage());
        Assert.assertFalse(myResources.isResourceDisplayed(resourceName));
    }
}
