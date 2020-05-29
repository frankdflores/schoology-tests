package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class CreatePopup {

    @FindBy(css = "#edit-submit")
    protected WebElement submitButton;

    private WebDriver driver;

    public CreatePopup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
