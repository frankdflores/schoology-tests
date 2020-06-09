package org.example.schoology.tests;

import org.example.schoology.pages.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ResourcesTest {

    public static final String PREFIX_AT = "AT";

    @Test
    public void deleteQuestionBank() {

        Login login = new Login();
        Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
        Resources resourcePage = home.clickMenuResource("Resources");
        resourcePage.addResource();
        CreateQuestionBankPopup createQuestionBankPopup = resourcePage.addQuestionBank();

        String questionBankName = PREFIX_AT + "question bank" + System.currentTimeMillis();

        Map<String, String> addQuestionBankMap = new HashMap<>();
        addQuestionBankMap.put("name", questionBankName);
        addQuestionBankMap.put("description", "Description");

        AddQuestionBankPage addQuestionBankPage = createQuestionBankPopup.create(addQuestionBankMap);

        resourcePage.clickEditQuestionBank(questionBankName);

        String deletedSuccessfully = "Your item has been removed.";

        Assert.assertEquals(deletedSuccessfully, resourcePage.getMessage());
        Assert.assertEquals("", resourcePage.getResourceName(questionBankName));




    }
}
