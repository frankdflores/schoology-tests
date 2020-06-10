package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class AddQuestionBankPopup {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(css = "#edit-title")
	private WebElement nameTextField;

	@FindBy(css = "#edit-description")
	private WebElement descriptionTextField;

	@FindBy(css = "#edit-enable-tracking")
	private WebElement enableQuestionTrackingCheckBox;

	@FindBy(css = "input[id='edit-submit'][value='Create']")
	private   WebElement createButton;

	public AddQuestionBankPopup(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	private void setName(String name) {
		nameTextField.sendKeys(name);
	}

	private void setDescription(String description){
		descriptionTextField.sendKeys(description);
	}

	private void setEnableQuestionTracking(boolean enable){
		if (enable) {
			if (!enableQuestionTrackingCheckBox.isSelected()) {
				enableQuestionTrackingCheckBox.click();
			}
		} else {
			if (enableQuestionTrackingCheckBox.isSelected()) {
				enableQuestionTrackingCheckBox.click();
			}
		}
	}

	private void fill(Map<String, String> questionBankMap) {
		Map<String, Step> stepsMap = new HashMap<>();
		stepsMap.put("name", () -> setName(questionBankMap.get("name")));
		stepsMap.put("description", () -> setDescription(questionBankMap.get("description")));
		stepsMap.put("enable question tracking", () -> setEnableQuestionTracking(Boolean.parseBoolean(questionBankMap.get("enable question tracking"))));

		for (String keyField : questionBankMap.keySet()) {
			stepsMap.get(keyField).execute();
		}
	}

	public Resources addQuestionBank(Map<String, String> questionBankMap) {
		fill(questionBankMap);
		createButton.click();
		return new Resources(driver);
	}
}
