package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Resources extends ViewList {

    @FindBy (xpath = "//img[@class='action-links-unfold-icon']//ancestor::div[@id='toolbar-add-wrapper']")
    private WebElement addResourceButton;

    @FindBy (css = "#collection-add-question-bank")
    private WebElement addQuestionBankButton;


    private final By deletePopUp = By.cssSelector("#popups-1");

    @FindBy(xpath="//input[@value='Delete']")
    private WebElement deleteButton;

    private static final String XPATH_RESOURCE_BY_NAME = ("//a[text()='%s']");

    public static final String RESOURCE_ACTION_BUTTON = "//a[text()='%s']/parent::td/following-sibling::td/child::div/child::div[@role='button']";
    public static final String DELETE_RESOURCE_ACTION_BUTTON = "//a[text()='%s']/ancestor::tr//ul//li[contains(@class,'action-delete')]";


    public AddQuestionPopup clickAddResources(){
        addResourceButton.click();
        addQuestionBankButton.click();
        return new AddQuestionPopup();
    }

    public Resources clickDeleteResource(String resourceName){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".messages .message-text")));
        driver.findElement(By.xpath(String.format(RESOURCE_ACTION_BUTTON, resourceName))).click();
        driver.findElement(By.xpath(String.format(DELETE_RESOURCE_ACTION_BUTTON, resourceName))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(deletePopUp));
        deleteButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".messages .message-text")));
        return new Resources();
    }

    public boolean getResourceByName(String resourceName){
        try {
            return driver.findElement(By.xpath(String.format(XPATH_RESOURCE_BY_NAME, resourceName))).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

}
