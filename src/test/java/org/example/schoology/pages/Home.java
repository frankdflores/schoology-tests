package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.*;
import java.util.*;

public class Home {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//a[@href='/resources' and text()='Resources']")
	private WebElement sub_menu_resources;


	public Home(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 30);
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

	public Resources clickResourceMenu(String menuName) {
			sub_menu_resources.click();

		return new Resources(driver);
	}

}
