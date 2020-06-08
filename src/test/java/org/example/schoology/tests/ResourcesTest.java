package org.example.schoology.tests;
import org.example.schoology.pages.CreateQuestionBankPopup;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.Resources;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class ResourcesTest {

    public static final String PREFIX_AT = "AT_";

    @Test
    public void DeleteQuestionBankResource() {
        Login login = new Login();
        Home home = login.loginAs("ovando.noni@gmail.com", "Testnovando123E@");
        Resources resources = home.clickResourceMenu("Resources");
        CreateQuestionBankPopup createResourceQuestionPopup = resources.clickCreateQuestionBankButton();

        String resourceQuestionName = PREFIX_AT + "Resource Question" + System.currentTimeMillis();

        Map<String, String> resourceQuestionMap = new HashMap<>();
        resourceQuestionMap.put("name", resourceQuestionName);
        resourceQuestionMap.put("description", "This is a description");
        resourceQuestionMap.put("tracking", "True");
        resources = createResourceQuestionPopup.CreateQuestionBank(resourceQuestionMap);

        // When
         resources.clickDeleteQuestionBankButton(resourceQuestionName);

        Assert.assertEquals(false, resources.existResourceQuestionByName(resourceQuestionName));
        //Assert.assertEquals("Your item has been removed.", resources.getMessage());

    }

}
