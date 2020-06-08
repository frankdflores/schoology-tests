package org.example.schoology.tests;

import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.PopupQuestionBank;
import org.example.schoology.pages.Resources;
import org.example.schoology.pages.SubMenu;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ResourcesTest {
    public static final String PREFIX_AT = "AT_";
    @Test
    public void CreateAndDeleteResource() {
        Login login = new Login();
        Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
        Resources resources = home.clickResourceButton();
        resources.clickAddResources();
        PopupQuestionBank popupQuestionBank = resources.clickAddQuestionBank();

        String resourceName = PREFIX_AT + "Test Resources" + System.currentTimeMillis();
        Map<String, String> resourceMap = new HashMap<>();
        resourceMap.put("name", resourceName);
        resourceMap.put("description", "Description");
        resourceMap.put("enableQuestionTracking", "True");
        resources = popupQuestionBank.createQuestionBank(resourceMap);

        resources.deleteResources(resourceName);

        Assert.assertEquals("Your item has been removed.", resources.getMessage());

        boolean bool = resources.getResourceByName(resourceName);
        Assert.assertFalse(bool);
    }
}
