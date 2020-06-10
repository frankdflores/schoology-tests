package org.example.schoology.pages.groups;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Groups {

	private static final String COURSE_ACTIONS_BUTTON = "//a[text()='%s']/ancestor::li//div[contains(@class,'action-links-unfold')]";

	@FindBy(css = "a.create-group")
	private WebElement createGroupButton;

	@FindBy(css = "ul[style=\"display: block;\"] .action-edit")
	private WebElement editGroup;

	@FindBy(css = ".message-text")
	private WebElement messageText;

	private WebDriver driver;

	private WebDriverWait wait;

	public Groups(final WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
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

	public String getMessage() {
		wait.until(ExpectedConditions.visibilityOf(messageText));
		return messageText.getText();
	}
}
