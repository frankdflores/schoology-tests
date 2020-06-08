package org.example.schoology.tests;

import org.example.schoology.pages.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ResourcesTest {
    public static final String PREFIX_AT = "AT_";

    @Test
    public void deleteResource() {

        //Given
        Login login = new Login();
        Home home = login.loginAs("dennis.gamboa17@hotmail.com", "P4ssw0rd123");
        Resources resources = (Resources) home.clickMenu("Resources");
        AddQuestionBankPopup addResourcePopup = (AddQuestionBankPopup) resources.addResource("Add Question Bank");

        String addQuestionBankName = PREFIX_AT + "Test Add Question Bank" + System.currentTimeMillis();
        Map<String, String> addQuestionBankMap = new HashMap<>();
        addQuestionBankMap.put("name", addQuestionBankName);
        addQuestionBankMap.put("description", "Add Question Bank Description");
        addQuestionBankMap.put("enable", "true");
        resources = addResourcePopup.create(addQuestionBankMap);

        // When
        DeleteResourcePopup deleteResource = resources.clickDeleteResource(addQuestionBankName);
        resources = deleteResource.delete();

        // Then
        Assert.assertEquals("Your item has been removed.", resources.getMessage());
        Assert.assertEquals("", resources.getResourceName(addQuestionBankName));
    }

}
