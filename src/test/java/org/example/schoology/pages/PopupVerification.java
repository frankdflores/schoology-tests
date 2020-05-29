package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopupVerification {

    private WebDriver driver;

    @FindBy(css = "div.popups-close")
    private WebElement closeButton;

    public PopupVerification(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Home close() {
        closeButton.click();
        return new Home(driver);
    }

}
