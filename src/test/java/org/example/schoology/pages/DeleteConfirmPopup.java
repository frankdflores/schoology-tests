package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteConfirmPopup {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(css = "input[id='edit-submit'][value='Delete']")
	private  WebElement deleteButton;

	public DeleteConfirmPopup(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.visibilityOf(deleteButton));
	}

	public Resources confirmDelete(){
		deleteButton.click();
		return new Resources(driver);
	}
}
