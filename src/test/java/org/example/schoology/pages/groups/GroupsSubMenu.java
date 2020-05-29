package org.example.schoology.pages.groups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GroupsSubMenu {

	private WebDriver driver;

	@FindBy(css = "a[href='/groups']")
	private WebElement myGroupsLink;

	public GroupsSubMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Groups clickMyGroupsLink() {
		myGroupsLink.click();
		return new Groups(driver);
	}
}
