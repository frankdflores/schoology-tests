package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Resources {

    WebDriver driver;

    @FindBy(css = "#toolbar-add")
    WebElement addNewResourceButton;

    @FindBy(css = "#collection-add-question-bank")
    WebElement addNewQuestionBank;

    public Resources(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addResource(){
        addNewResourceButton.click();
    }

    public void addQuestionBank(){
        addNewQuestionBank.click();
    }


}
