package org.example.schoology.tests;

import org.example.schoology.pages.*;
import org.junit.Assert;
import org.junit.Test;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.SubMenu;
import java.util.HashMap;
import java.util.Map;


public class ResourceTest {

    public static final String PREFIX_AT = "AT_";

    @Test
    public void editCourseTest() {
        // Given
        Login login = new Login();
        Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
        //SubMenu subMenu = home.clickResourceMenu();
        //Resources resources = subMenu.clickMyResourcesLink();
        Resources resources = home.clickResourceMenu();
        resources.addResources();
        QuestionBankPopup  questionBankPopup = resources.clickAddQuestionBank();

        // When
        String resourceName = PREFIX_AT + "Test Resources" + System.currentTimeMillis();
        Map<String, String> resourceMap = new HashMap<>();
        resourceMap.put("name", resourceName);
        resourceMap.put("description", "Description");
        resourceMap.put("enableQuestionTracking", "True");
        resources = questionBankPopup.createQuestionBank(resourceMap);

        // Then
        resources.deleteResources(resourceName);

        Assert.assertEquals("Your item has been removed.", resources.getMessage());
        Assert.assertFalse(resources.getResourceByName(resourceName));
    }

}