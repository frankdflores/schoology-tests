package org.example.schoology.pages.groups;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Groups {
	private static final String COURSE_ACTIONS_BUTTON = "//span[text()='%s']/ancestor::li//div[@class='action-links-unfold ']";
	private WebDriver driver;

	@FindBy(css = "a.create-group")
	private WebElement createGroupButton;

	@FindBy(css = "ul[style=\"display: block;\"] .action-edit")
	private WebElement editGroup;

	public Groups(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public CreateGroupPopup clickCreateGroupButton() {
		createGroupButton.click();
		return new CreateGroupPopup(driver);
	}

	public EditGroupPopup clickEditGroup(final String groupName) {
		WebElement courseActionsButton = driver.findElement(By.xpath(String.format(COURSE_ACTIONS_BUTTON, groupName)));

		// Scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", courseActionsButton);

		courseActionsButton.click();
		editGroup.click();
		return new EditGroupPopup(driver);
	}
}
