package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public class CreateGroupPopup {

	@FindBy(css = "#edit-name")
	private WebElement groupNameTextField;

	@FindBy(css = "textarea#edit-description")
	private WebElement descriptionTextField;

	@FindBy(css = "#edit-privacy-level" )
	private WebElement privacyDropDown;

	@FindBy(css = "#edit-invite-type")
	private WebElement accessDropDown;

	@FindBy(css = "#edit-category")
	private WebElement categoryDropDown;

	@FindBy(css = "#edit-submit")
	private  WebElement submitButton;

	private WebDriver driver;

	public CreateGroupPopup(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setName(String name) {
		groupNameTextField.sendKeys(name);
	}

	public void setDescription(String description) {
		WebElement descriptionField = descriptionTextField;
		descriptionField.clear();
		descriptionField.sendKeys(description);
	}

	public void selectPrivacy(String privacy) {
		Select privacyField = new Select(privacyDropDown);
		privacyField.selectByVisibleText(privacy);
	}

	public void selectAccess(String access) {
		Select accessField = new Select(accessDropDown);
		accessField.selectByVisibleText(access);
	}

	public void selectCategory(String category) {
		Select categoryField = new Select(accessDropDown);
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
