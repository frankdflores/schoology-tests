package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {

	private WebDriver driver;
	private WebDriverWait wait;

	public Home(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	public SubMenu clickMenu(String menuName) {
		driver.findElement(By.xpath(String.format("//a[text()='%s']", menuName))).click();
		return new SubMenu(driver);
	}

}
