package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class QuestionBankPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(css = "#collection-view")
	private WebElement resourcesHome;

	@FindBy(css = "#popups-1")
	private WebElement deletePopup;


	public QuestionBankPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);

		wait.until(ExpectedConditions.visibilityOf(resourcesHome));
	}

	public DeletePopupPage deleteQuestionBank(String questionBankName) {
		String format = String.format("//a[text()='%s']/ancestor::td[contains(@class, 'collection-item-title')]//following-sibling::td/div/div", questionBankName);
		this.driver.findElement(By.xpath(format)).click();
		this.driver.findElement(By.xpath("//ul[@style='display: block;']//a[text()='Delete ']")).click();

		wait.until(ExpectedConditions.visibilityOf(deletePopup));
		return new DeletePopupPage(this.driver);
	}

	public boolean isNotPresent(String questionBankName) {
		List<WebElement> listOfElements = driver.findElements(By.xpath("//a[contains(@class,'item-title active ')]"));

		for (int i=0; i<listOfElements.size();i++){
			//System.out.println("aaaaaaaaaaa:" + listOfElements.get(i).getText());//;.getAttribute("text()"));
			if(listOfElements.get(i).getText() == questionBankName) {
				return false;
			}
		}
		return true;

	}
}
