package org.example.schoology.pages;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	// This info should come from config file.
	public static final int DEFAULT_IMPLICIT_TIMEOUT = 15;
	public static final int MIN_IMPLICIT_TIMEOUT = 3;

	private WebDriver driver;

	@FindBy(css = "#edit-mail")
	private WebElement usernameTextField;

	@FindBy(css = "#edit-pass")
	private WebElement passwordTextField;

	@FindBy(css = "#edit-submit")
	private WebElement loginButton;

	@FindBy(css = "#confirmation_cancel")
	private WebElement cancelVerifyYourAccountButton;

	public Login() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		driver.get("https://app.schoology.com/login");
		PageFactory.initElements(driver, this);
	}

	public Home loginAs(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
		verifyYourAccount();
		return new Home(driver);
	}

	private void verifyYourAccount() {
		try {
//			// Changing timeout
			driver.manage().timeouts().implicitlyWait(MIN_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
			cancelVerifyYourAccountButton.click();
		} catch (NoSuchElementException e) {
			// nothing.
		} finally {
//			// Restore timeout
			driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		}
	}

}
