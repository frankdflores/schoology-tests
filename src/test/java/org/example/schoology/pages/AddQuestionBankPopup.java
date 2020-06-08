package org.example.schoology.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;

public class AddQuestionBankPopup extends AbstractQuestionBankPopup {

	public AddQuestionBankPopup(WebDriver driver) {
		super(driver);
	}

	public QuestionBankPage create(Map<String, String> questionMap) {
		fill(questionMap);
		createButton.submit();
		return new QuestionBankPage(driver);
	}

}
