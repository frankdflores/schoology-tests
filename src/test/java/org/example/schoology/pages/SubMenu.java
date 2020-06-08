package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubMenu {

	private WebDriver driver;

	public SubMenu(WebDriver driver) {
		this.driver = driver;
	}

	public AddQuestionBankPopup clickAddResourcesButton() {
		driver.findElement(By.cssSelector("div#toolbar-add")).click();
		driver.findElement(By.xpath("//a[text()='Add Question Bank']")).click();
		return new AddQuestionBankPopup(driver);
	}

}
