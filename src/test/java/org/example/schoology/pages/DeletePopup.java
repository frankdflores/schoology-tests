package org.example.schoology.pages;

import org.example.schoology.pages.resources.MyResources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePopup {

    protected WebDriver driver;

    @FindBy(css = "form[action*='delete'] #edit-submit")
    protected WebElement deleteButton;

    public DeletePopup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MyResources clickDeleteButton() {
        deleteButton.click();
        return new MyResources(driver);
    }
}
