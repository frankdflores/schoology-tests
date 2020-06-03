package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GroupPage {

    private WebDriver driver;
    public GroupPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

