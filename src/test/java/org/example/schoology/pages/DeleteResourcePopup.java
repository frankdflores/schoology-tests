package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteResourcePopup extends AbstractPage {

    private WebDriver driver;

    @FindBy(css = "input[value='Delete']")
    private WebElement deleteButton;

    public Resources clickDeleteButton(){
        deleteButton.click();
        return new Resources();
    }

}
