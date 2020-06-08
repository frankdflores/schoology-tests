package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Resources {
    public static final String ADD_RESOURCE_ACTIONS_BUTTON = "//div[@id='toolbar-add']/child::div[@class='action-links-unfold ']";
    public static final String RESOURCE_ACTIONS_BUTTON = "//a[text()='%s']/following::div[@class='action-links-unfold ']";
    public static final String RESOURCE_ACTIONS_DELETE_OPTION = "//a[text()='%s']/following::a[@class='action-delete  sExtlink-processed popups-processed']";
    public static final String RESOURCE_ITEM = "//a[text()='%s']";


    @FindBy(css = "#collection-add-question-bank")
    private WebElement addQuestionBankOption;

    @FindBy(css = ".messages .message-text")
    private WebElement messages;


    private WebDriver driver;
    private WebDriverWait wait;

    public Resources(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public AddResourcePopup clickAddResource (String resourceOption){
        WebElement addResourceButton = driver.findElement(By.xpath(ADD_RESOURCE_ACTIONS_BUTTON));

        addResourceButton.click();
        addQuestionBankOption.click();
        return new AddResourcePopup(driver);
    }

    public DeleteResourcePopup clickRemoveResource(String resourceName){

        WebElement resourceActionsButton = driver.findElement(By.xpath(String.format(RESOURCE_ACTIONS_BUTTON, resourceName)));
        WebElement resourceActionsDeleteOption = driver.findElement(By.xpath(String.format(RESOURCE_ACTIONS_DELETE_OPTION, resourceName)));

        resourceActionsButton.click();
        resourceActionsDeleteOption.click();

        return new DeleteResourcePopup (driver);

    }

    public String resourceItemExist(String resourceName){
        try {
            return driver.findElement(By.xpath(String.format(RESOURCE_ITEM, resourceName))).getText();
        }
        catch (NoSuchElementException e) {
            return "";
        }
    }

    public String getMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(messages));
        return messages.getText();
    }

}
