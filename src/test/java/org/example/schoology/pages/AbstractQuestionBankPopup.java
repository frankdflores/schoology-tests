package org.example.schoology.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractQuestionBankPopup {

	@FindBy(css = "#edit-title")
	private WebElement nameTextField;

	@FindBy(css = "textarea#edit-description")
	private WebElement descriptionTextField;

	@FindBy(css = "#edit-enable-tracking")
	private WebElement questionTrackingCheckBox;

	@FindBy(xpath = "//input[@value='Create']")
	protected  WebElement createButton;

	protected WebDriver driver;

	protected WebDriverWait wait;

	public AbstractQuestionBankPopup(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	public void fill(Map<String, String> bankMap) {
		Map<String, Step> stepsMap = new HashMap<>();
		stepsMap.put("name", () -> setName(bankMap.get("name")));
		stepsMap.put("description", () -> setDescription(bankMap.get("description")));

		questionTrackingCheckBox.click();

		for (String keyField : bankMap.keySet()) {
			stepsMap.get(keyField).execute();
		}
	}

	public void setName(String name) {
		nameTextField.sendKeys(name);
	}

	private void setDescription(String descr) {
		descriptionTextField.sendKeys(descr);
	}


}
