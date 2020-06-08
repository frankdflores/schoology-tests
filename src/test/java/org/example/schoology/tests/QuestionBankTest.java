package org.example.schoology.tests;

import java.util.HashMap;
import java.util.Map;

import org.example.schoology.pages.*;

import org.junit.Test;

public class QuestionBankTest {

	@Test
	public void editCourseTest() {

		Login login = new Login();
		Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
		SubMenu subMenu = home.clickMenu("Resources");

		AddQuestionBankPopup addQuestionBankPopup = subMenu.clickAddResourcesButton();
		Map<String, String> questionBankMap = new HashMap<>();
		questionBankMap = new HashMap<>();
		String questionBankName = "MyQuestionB";
		questionBankMap.put("name", questionBankName);
		questionBankMap.put("description", "Description of MyQuestionB");
		QuestionBankPage questionBankPage = addQuestionBankPopup.create(questionBankMap);

		DeletePopupPage deletePopupPage = questionBankPage.deleteQuestionBank(questionBankName);
		deletePopupPage.clickDelete();
		if(questionBankPage.isNotPresent(questionBankName))
			System.out.println("Question Bank item has been removed from list");
		else
			System.out.println("Bank Item still listed on UI, it is not removed");
	}

}
