package org.example.schoology.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Resources {

	@FindBy(xpath = "//span[text()='Add Resources']/../../div[@class='action-links-unfold']")
	private WebElement addResourcesButton;

	@FindBy(css = ".add-question-bank a")
	private WebElement addQuestionBankButton;

	public static final String RESOURCE_ACTIONS_BUTTON = "//a[text()='%s']/ancestor::tr//div[@class='action-links-unfold']";
	public static final String XPATH_RESOURCE_BY_NAME = "//a[text()='%s' and contains(@class,'item-title')]";

	private WebDriver driver;
	private WebDriverWait wait;
	public static final int DEFAULT_IMPLICIT_TIMEOUT = 15;
	public static final int MIN_IMPLICIT_TIMEOUT = 3;

	@FindBy(css = "a.create-course-btn")
	private WebElement createCourseButton;

	@FindBy(css = "ul[style=\"display: block;\"] .action-delete a")
	private WebElement deleteCourse;

	@FindBy(css = ".messages .message-text")
	private WebElement messages;

	public Resources(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.visibilityOf(addResourcesButton));
	}

	public AddQuestionBankPopup addQuestionBank() {
		addResourcesButton.click();
		addQuestionBankButton.click();
		return new AddQuestionBankPopup(driver);
	}

	public DeleteConfirmPopup clickDeleteResource(String resourceName) {
		WebElement actionsButton = driver.findElement(By.xpath(String.format(RESOURCE_ACTIONS_BUTTON, resourceName)));

		// Scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", actionsButton);

		actionsButton.click();
		deleteCourse.click();
		return new DeleteConfirmPopup(driver);
	}

	public String getMessage() {
		return messages.getText();
	}

	public boolean verifyResource(String resourceName) {
		try {
			driver.manage().timeouts().implicitlyWait(MIN_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
			driver.findElement(By.xpath(String.format(XPATH_RESOURCE_BY_NAME, resourceName)));
		} catch (NoSuchElementException e) {
			return false;
		} finally {
			driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		}
		return true;
	}
}
