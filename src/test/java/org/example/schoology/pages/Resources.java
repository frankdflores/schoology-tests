package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Resources extends AbstractPage {
    public static final String ADD_RESOURCE_ACTIONS_BUTTON = "//div[@id='toolbar-add']/child::div[@class='action-links-unfold ']";
    public static final String RESOURCE_ACTIONS_BUTTON = "//a[text()='%s']/following::div[@class='action-links-unfold ']";
    public static final String RESOURCE_ACTIONS_DELETE_OPTION = "//a[text()='%s']/following::a[@class='action-delete  sExtlink-processed popups-processed']";
    public static final String RESOURCE_ITEM = "//a[text()='%s']";


    @FindBy(css = "#collection-add-question-bank")
    private WebElement addQuestionBankOption;

    @FindBy(css = "#collection-add-assessment")
    private WebElement addTestQuizOption;

    @FindBy(css = ".messages .message-text")
    private WebElement messages;

    @FindBy(css = "#library-wrapper div.messages-container")
    private WebElement messageContainer;

    public void clickAddResourcesButton(){
        WebElement addResourceButton = driver.findElement(By.xpath(ADD_RESOURCE_ACTIONS_BUTTON));
        addResourceButton.click();
    }

    public AddQuestionBankResourcePopup clickAddQuestionBankResource(){
        clickAddResourcesButton();
        addQuestionBankOption.click();
        return new AddQuestionBankResourcePopup();
    }

    public AddTestQuizResourcePopup clickAddTestQuizResource(){
        clickAddResourcesButton();
        addTestQuizOption.click();
        return new AddTestQuizResourcePopup();
    }

    public DeleteResourcePopup clickRemoveResource(String resourceName){

        WebElement resourceActionsButton = driver.findElement(By.xpath(String.format(RESOURCE_ACTIONS_BUTTON, resourceName)));
        WebElement resourceActionsDeleteOption = driver.findElement(By.xpath(String.format(RESOURCE_ACTIONS_DELETE_OPTION, resourceName)));

        resourceActionsButton.click();
        resourceActionsDeleteOption.click();

        return new DeleteResourcePopup ();

    }

    public boolean resourceItemExist(String resourceName){
        try {
           driver.findElement(By.xpath(String.format(RESOURCE_ITEM, resourceName))).getText();
           return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(messages));
        return messages.getText();
    }

    public void waitForMessageContainerDisappear(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#library-wrapper div.messages-container")));
    }

}
