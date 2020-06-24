package org.example.schoology.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Resources extends ViewList {


    public static final String EDIT_RESOURCE_QUESTION_ACTIONS_BUTTON = "//a[text()='%s']/ancestor::tr//div[contains(@class, 'action-links-unfold')]";

    public static final int DEFAULT_IMPLICIT_TIMEOUT = 15;
    public static final int MIN_IMPLICIT_TIMEOUT = 30;

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

    public CreateQuestionBankPopup clickCreateQuestionBankButton() {
        addQuestionButton.click();
        addQuestionItem.click();
        return new CreateQuestionBankPopup();
    }


    public Resources clickDeleteQuestionBankButton(String nameResource) {

        WebElement editActionsButton = driver.findElement(By.xpath(String.format(EDIT_RESOURCE_QUESTION_ACTIONS_BUTTON, nameResource)));

        // Scroll
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView();", editActionsButton);
        wait.until(ExpectedConditions.visibilityOf(editActionsButton));
        editActionsButton.click();
        deleteResourceQuestionItem.click();
        deleteResourceQuestionButton.click();
        return new Resources();
    }

    public boolean existResourceQuestionByName(String nameResource) {

        try {
			WebElement editActionsButton = driver.findElement(By.xpath(String.format(EDIT_RESOURCE_QUESTION_ACTIONS_BUTTON, nameResource)));
            if(editActionsButton == null)
                return false;
            else
                return true;
        } catch (NoSuchElementException e) {
            // nothing.
            return false;
        }finally {
//			// Restore timeout
            driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
            return false;
        }
    }


}
