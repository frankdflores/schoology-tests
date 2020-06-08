package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Resources {
    private WebDriver driver;
    protected WebDriverWait wait;


    @FindBy (xpath = "//img[@class='action-links-unfold-icon']//ancestor::div[@id='toolbar-add-wrapper']")
    private WebElement addResourceButton;

    @FindBy (css = "#collection-add-question-bank")
    private WebElement addQuestionBankButton;

    @FindBy(css= ".messages .message-text")
    private WebElement messages;

    private final By deletePopUp = By.cssSelector("#popups-1");

    @FindBy(xpath="//input[@value='Delete']")
    private WebElement deleteButton;

    private static final String XPATH_RESOURCE_BY_NAME = ("//a[text()='%s']/parent::td");

    public static final String RESOURCE_ACTION_BUTTON = "//a[text()='%s']/parent::td/following-sibling::td/child::div/child::div[@role='button']";
    public static final String DELETE_RESOURCE_ACTION_BUTTON = "//a[text()='%s']/ancestor::tr//ul//li[contains(@class,'action-delete')]";


    public Resources(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 30);
    }

    public AddQuestionPopup clickAddResources(){
        addResourceButton.click();
        addQuestionBankButton.click();
        return new AddQuestionPopup(driver);
    }

    public Resources clickDeleteResource(String resourceName){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".messages .message-text")));
        driver.findElement(By.xpath(String.format(RESOURCE_ACTION_BUTTON, resourceName))).click();
        driver.findElement(By.xpath(String.format(DELETE_RESOURCE_ACTION_BUTTON, resourceName))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(deletePopUp));
        deleteButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".messages .message-text")));
        return new Resources(driver);
    }

    public String getMessage(){
        return messages.getText();
    }

    public boolean getResourceByName(String resourceName){
        try {
            driver.findElement(By.xpath(String.format(XPATH_RESOURCE_BY_NAME, resourceName))).getText();
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
