package org.example.schoology.pages.groups;

import org.example.schoology.pages.courses.CreateCoursePopup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Groups {

	private WebDriver driver;

	@FindBy(css = "a.create-group")
	private WebElement createGroupButton;

	public Groups(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public CreateGroupPopup clickCreateGroupButton() {
		createGroupButton.click();
		return new CreateGroupPopup(driver);
	}
}
