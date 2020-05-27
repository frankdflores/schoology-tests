package org.example.schoology.pages;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	private WebDriver driver;

	@FindBy(css = "#edit-mail")
	private WebElement usernameTextField;

	@FindBy(css = "#edit-pass")
	private WebElement passwordTextField;

	@FindBy(css = "#edit-submit")
	private WebElement loginButton;

	//Temporal: test account needs a Manual verification
	@FindBy(css = "#confirmation_cancel")
	private WebElement confirm_cancel;

	public Login() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://app.schoology.com/login");
		PageFactory.initElements(driver, this);
	}

	public Home loginAs(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
		confirmAlert();
		return new Home(driver);
	}

	//Temporal: test account needs a Manual verification
	public void confirmAlert() {
		confirm_cancel.click();
	}

}
