package org.example.schoology.pages.groups;

import org.example.schoology.pages.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractGroupPopup {

	@FindBy(css = "#edit-name")
	private WebElement groupNameTextField;

	@FindBy(css = "#edit-description")
	private WebElement descriptionTextArea;

	@FindBy(css = "#edit-privacy-level" )
	private WebElement privacyDropDown;

	@FindBy(css = "#edit-invite-type")
	private WebElement accessDropDown;

	@FindBy(css = "#edit-category")
	private WebElement categoryDropDown;

	@FindBy(css = ".create-form #edit-submit")
	protected WebElement submitButton;

	protected WebDriver driver;

	public AbstractGroupPopup(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private void setName(final String name) {
		groupNameTextField.sendKeys(name);
	}

	private void setDescription(final String description) {
		descriptionTextArea.sendKeys(description);
	}

	private void selectPrivacy(final String privacy) {
		Select privacyArea = new Select(privacyDropDown);
		privacyArea.selectByVisibleText(privacy);
	}

	private void selectAccess(final String access) {
		Select accessField = new Select(accessDropDown);
		accessField.selectByVisibleText(access);
	}

	private void selectCategory(final String category) {
		Select categoryField = new Select(categoryDropDown);
		categoryField.selectByVisibleText(category);
	}

	public void fill(Map<String, String> courseMap) {
		Map<String, Step> stepsMap = new HashMap<>();
		stepsMap.put("name", () -> setName(courseMap.get("name")));
		stepsMap.put("description", () -> setDescription(courseMap.get("description")));
		stepsMap.put("privacy", () -> selectPrivacy(courseMap.get("privacy")));
		stepsMap.put("access", () -> selectAccess(courseMap.get("access")));
		stepsMap.put("category", () -> selectCategory(courseMap.get("category")));

		for (String keyField : courseMap.keySet()) {
			stepsMap.get(keyField).execute();
		}
	}
}
