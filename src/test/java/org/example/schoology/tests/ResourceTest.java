package org.example.schoology.tests;

import org.example.schoology.pages.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ResourceTest {

	public static final String PREFIX_AT = "AT_";

	@Test
	public void deleteQuestionBank() {
		Login login = new Login();
		Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
		Resources resources = home.clickResourcesMenu();

		String questionBankName = PREFIX_AT + "Test Question Bank" + System.currentTimeMillis();
		Map<String, String> questionMap = new HashMap<>();
		questionMap.put("name", questionBankName);
		questionMap.put("description", "Description Question Bank");
		questionMap.put("enable question tracking", "True");

		AddQuestionBankPopup addQuestionBankPopup = resources.addQuestionBank();
		addQuestionBankPopup.addQuestionBank(questionMap);

		// Delete resource
		resources.clickDeleteResource(questionBankName)
				.confirmDelete();

		// Validate deletion
		Assert.assertEquals("Your item has been removed.", resources.getMessage());
		Assert.assertFalse("Question Bank was not removed", resources.verifyResource(questionBankName));
	}
}
