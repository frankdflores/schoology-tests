package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeletePopupPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteButton;

    public DeletePopupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 30);
        PageFactory.initElements(this.driver, this);
    }

    public void clickDelete() {
        deleteButton.click();
    }
}
