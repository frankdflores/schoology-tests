package org.example.schoology.pages;

import org.example.schoology.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Resources extends AbstractPage {

    public static final String QUESTION_ADD_ACTIONS_BUTTON = "//div[@id='toolbar-add']/child::div[@class='action-links-unfold ']";
    public static final String QUESTION_ACTIONS_BUTTON = "//a[text()='%s']/following::div[@class='action-links-unfold ']";
    public static final String QUESTION_ACTIONS_DELETE_BUTTON = "//a[text()='%s']/following::a[@class='action-delete  sExtlink-processed popups-processed']";
    public static final String RESOURCE_BY_NAME = "//a[text()='%s']";

    @FindBy(css = "#collection-add-question-bank")
    private WebElement addQuestionBankOption;

    @FindBy(css = ".messages .message-text")
    private WebElement messages;

    @FindBy(css = "#library-wrapper div.messages-container")
    private WebElement messageContainer;

    public CreateQuestionBankPopup clickAddResourcesBtn(String resourceOption) {
        WebElement addResourceButton = driver.findElement(By.xpath(QUESTION_ADD_ACTIONS_BUTTON));
        addResourceButton.click();

        switch (resourceOption){
            case "Add Question Bank":
                addQuestionBankOption.click();
                break;
        }
        return new CreateQuestionBankPopup();
    }

    public DeleteQuestionBank clickDeleteQuestion(String questionName) {
        WebElement questionActionsButton = driver.findElement(By.xpath(String.format(QUESTION_ACTIONS_BUTTON, questionName)));
        WebElement deleteQuestion = driver.findElement(By.xpath(String.format(QUESTION_ACTIONS_DELETE_BUTTON,questionName)));

        questionActionsButton.click();
        deleteQuestion.click();
        return new DeleteQuestionBank();
    }

    public String getMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(messages));
        return messages.getText();
    }

    public boolean getResourceByName(String questionName) {
        try {
            driver.findElement(By.xpath(String.format(RESOURCE_BY_NAME, questionName))).getText();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void waitForMessageContainerDisappear(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#library-wrapper div.messages-container")));
    }
}
