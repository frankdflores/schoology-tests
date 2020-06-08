package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteResourcePopup {

    private WebDriver driver;

    @FindBy(css = "input[value='Delete']")
    private WebElement deleteButton;



    public DeleteResourcePopup(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Resources clickDeleteButton(){
        deleteButton.click();
        return new Resources(driver);
    }

}
