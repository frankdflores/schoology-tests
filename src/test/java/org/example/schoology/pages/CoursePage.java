package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoursePage {

	private final By cssCourseProfile = By.cssSelector("#course-profile-materials");

	private WebDriver driver;

	private WebDriverWait wait;

	@FindBy(css = "#course-profile-materials")
	private WebElement courseProfileMaterials;

	public CoursePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);

		wait.until(ExpectedConditions.visibilityOf(courseProfileMaterials));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cssCourseProfile));
	}
}
