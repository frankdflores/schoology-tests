package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SubMenu {

	private WebDriver driver;

	//@FindBy(xpath = "//a[contains(@href,'courses')]")
	@FindBy(css = "a[href='/courses']")
	private WebElement sub_menu_course;

	@FindBy(css = "a[href='/groups']")
	private WebElement sub_menu_group;


	public SubMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Courses clickMyCoursesLink() {
		sub_menu_course.click();
		//driver.findElement(By.cssSelector(String.format("a[href='/%s']",name_menu))).click();
		return new Courses(driver);
	}

	public Groups clickGroupsLink() {
		sub_menu_group.click();
		//driver.findElement(By.cssSelector(String.format("a[href='/%s']",name_menu))).click();
		return new Groups(driver);
	}



}
