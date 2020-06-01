package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.*;
import java.util.*;

public class Home {

	private WebDriver driver;

    	public Home(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This only works for Courses and Groups
	 * Resources and More menu has another behavior.
	 * @param menuName
	 * @return
	 */
	public SubMenu clickMenu(String menuName) {
		driver.findElement(By.xpath(String.format("//span[text()='%s']/parent::button", menuName))).click();
		return new SubMenu(driver);
	}

}
