package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubMenu extends AbstractPage {

	public void clickViewListLink(String menu) {
		driver.findElement(By.cssSelector(String.format("a[href='/%s']", menu.toLowerCase()))).click();
	}
}
