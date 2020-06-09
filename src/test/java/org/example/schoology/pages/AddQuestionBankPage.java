package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddQuestionBankPage {

    WebDriver driver;

    public AddQuestionBankPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
