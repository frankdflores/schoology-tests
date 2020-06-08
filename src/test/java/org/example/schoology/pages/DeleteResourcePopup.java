package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteResourcePopup {

    private WebDriver driver;

    @FindBy(css = "#edit-submit[value=\"Delete\"]")
    private WebElement deleteButton;

    @FindBy(css = ".cancel-btn.schoology-processed")
    private  WebElement cancelButton;

    public DeleteResourcePopup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Resources delete() {
        deleteButton.click();
        return new Resources(driver);
    }

    public Resources cancel() {
        cancelButton.click();
        return new Resources(driver);
    }
}
