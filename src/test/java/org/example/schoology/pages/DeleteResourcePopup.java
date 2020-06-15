package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteResourcePopup extends AbstractPage {

    @FindBy(css = "#edit-submit[value=\"Delete\"]")
    private WebElement deleteButton;

    @FindBy(css = ".cancel-btn.schoology-processed")
    private  WebElement cancelButton;

    public Resources delete() {
        deleteButton.click();
        return new Resources();
    }

    public Resources cancel() {
        cancelButton.click();
        return new Resources();
    }
}
