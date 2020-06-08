package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GroupPage {

    private final By cssGroupProfile = By.cssSelector("#edit-submit");

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#edit-submit")
    private WebElement groupPost;

    public GroupPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(groupPost));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cssGroupProfile));
    }
}
