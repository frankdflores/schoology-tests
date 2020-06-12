package org.example.schoology.tests;

import org.example.schoology.pages.CreateQuestionBankPopup;
import org.example.schoology.pages.DeleteQuestionBank;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.Resources;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ResourcesTest {

    public static final String PREFIX_AQ = "AQ_";

    @Test
    public void deleteQuestionBank() {
        //Given
        Login login = new Login();
        Home home = login.loginAs("jacky.rosales84@gmail.com", "Control123");
        Resources resourcesPage = home.clickMenuResources("Resources");
        CreateQuestionBankPopup createQuestionBankPopup = resourcesPage.clickAddResourcesBtn("Add Question Bank");

        String questionName = PREFIX_AQ + "Test Question" + System.currentTimeMillis();

        Map<String, String> questionMap = new HashMap<>();
        questionMap.put("name", questionName);
        questionMap.put("description", "test question description");
        questionMap.put("enableTracking", "True");

        resourcesPage = createQuestionBankPopup.create(questionMap);
        resourcesPage.waitForMessageContainerDisappear();

        //When
        resourcesPage = home.clickMenuResources("Resources");
        DeleteQuestionBank deleteQuestionBank = resourcesPage.clickDeleteQuestion(questionName);
        Resources resources = deleteQuestionBank.delete();

        //Then
        Assert.assertEquals("Your item has been removed.", resources.getMessage());
        resources.waitForMessageContainerDisappear();
        boolean bool = resources.getResourceByName(questionName);
        Assert.assertFalse(bool);

    }

}
