package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupPage extends AbstractPage {

    private final By cssGroupProfile = By.cssSelector("#edit-submit");

    @FindBy(css = "#edit-submit")
    private WebElement groupPost;

    public GroupPage(){
        wait.until(ExpectedConditions.visibilityOf(groupPost));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cssGroupProfile));
    }
}


