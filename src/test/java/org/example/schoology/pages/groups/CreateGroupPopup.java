package org.example.schoology.pages.groups;

import org.example.schoology.pages.CreatePopup;
import org.example.schoology.pages.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public class CreateGroupPopup extends CreatePopup {

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

	public CreateGroupPopup(WebDriver driver) {
		super(driver);
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

	public void create(Map<String, String> courseMap) {
		Map<String, Step> stepsMap = new HashMap<>();
		stepsMap.put("name", () -> setName(courseMap.get("name")));
		stepsMap.put("description", () -> setDescription(courseMap.get("description")));
		stepsMap.put("privacy", () -> selectPrivacy(courseMap.get("privacy")));
		stepsMap.put("access", () -> selectAccess(courseMap.get("access")));
		stepsMap.put("category", () -> selectCategory(courseMap.get("category")));

		for (String keyField : courseMap.keySet()) {
			stepsMap.get(keyField).execute();
		}
		submitButton.click();
	}
}
