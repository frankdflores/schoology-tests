package org.example.schoology.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Resources {


    public static final String EDIT_RESOURCE_QUESTION_ACTIONS_BUTTON = "//a[text()='%s']/ancestor::tr//div[contains(@class, 'action-links-unfold')]";

    public static final int DEFAULT_IMPLICIT_TIMEOUT = 15;
    public static final int MIN_IMPLICIT_TIMEOUT = 30;

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//span[text()='Add Resources']/parent::div")
    private WebElement addQuestionButton;

    @FindBy(css = "ul[style=\"display: block;\"] .add-question-bank>a")
    private WebElement addQuestionItem;

    @FindBy(xpath = "//span[text()='Add Resources']/parent::div")
    private WebElement editQuestionButton;

    @FindBy(css = "ul[style=\"display: block;\"] .add-question-bank>a")
    private WebElement deleteQuestionItem;

    @FindBy(css = "ul[style=\"display: block;\"] .action-delete>a")
    private WebElement deleteResourceQuestionItem;

    @FindBy(xpath = "//input[@value='Delete' and @id='edit-submit']")
    private WebElement deleteResourceQuestionButton;

    @FindBy(css = ".messages .message-text")
    private WebElement deleteMessages;

    public Resources(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 30);

    }

    public CreateQuestionBankPopup clickCreateQuestionBankButton() {
        addQuestionButton.click();
        addQuestionItem.click();
        return new CreateQuestionBankPopup(driver);
    }

    public Resources clickDeleteQuestionBankButton(String nameResource) {

        WebElement editActionsButton = driver.findElement(By.xpath(String.format(EDIT_RESOURCE_QUESTION_ACTIONS_BUTTON, nameResource)));

        // Scroll
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView();", editActionsButton);

        editActionsButton.click();
        deleteResourceQuestionItem.click();
        deleteResourceQuestionButton.click();
        return new Resources(driver);
    }

    public String getMessage() {
        return deleteMessages.getText();

    }

    public boolean existResourceQuestionByName(String nameResource) {


        try {
//			// Changing timeout
            driver.manage().timeouts().implicitlyWait(MIN_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
            WebElement editActionsButton = driver.findElement(By.xpath(String.format(EDIT_RESOURCE_QUESTION_ACTIONS_BUTTON, nameResource)));
            return false;
        } catch (NoSuchElementException e) {
            // nothing.
            return true;
        }finally {
//			// Restore timeout
            driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        }
    }

}
