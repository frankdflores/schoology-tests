package org.example.schoology.tests;

import org.example.schoology.pages.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ResourcesTest {
    public static final String PREFIX_AT = "AT_";

    @Test
    public void resourceGroupTest() {

        //Given
        Login login = new Login();
        Home home = login.loginAs("LYNX_LEXX@hotmail.com", "TheTop86!");
        Resources resources = home.clickResourcesMenu("Resources");
        AddQuestionPopup addQuestionPopup = resources.clickAddResources();
        String resourceName = PREFIX_AT + "Test Resource01" + System.currentTimeMillis();
        Map<String, String> resourceMap = new HashMap<>();
        resourceMap.put("name", resourceName);
        resourceMap.put("description", "Description01");
        resources = addQuestionPopup.create(resourceMap);

        //When
        resources.clickDeleteResource(resourceName);


        //then
        Assert.assertEquals("Your item has been removed.", resources.getMessage());
        Assert.assertEquals(false, resources.getResourceByName(resourceName));

    }

}

