package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteQuestionBank {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(css = "input[id='edit-submit'][value='Delete']")
    protected WebElement submitButton;

    public DeleteQuestionBank(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public Resources delete() {
        submitButton.click();
        return new Resources(driver);
    }
}
