package org.example.schoology.pages;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.resources.AddQuestionBankResourcePopup;
import org.example.schoology.pages.resources.AddTestQuizResourcePopup;
import org.example.schoology.pages.resources.DeleteResourcePopup;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Resources extends AbstractPage {
    public static final String ADD_RESOURCE_ACTIONS_BUTTON = "//div[@id='toolbar-add']/child::div[@class='action"
            + "-links-unfold ']";
    public static final String RESOURCE_ACTIONS_BUTTON = "//a[text()='%s']/following::div[@class='action-links-unfold"
            + " ']";
    public static final String RESOURCE_ACTIONS_DELETE_OPTION = "//a[text()='%s']/following::a[@class='action-delete "
            + " sExtlink-processed popups-processed']";
    public static final String RESOURCE_ITEM = "//a[text()='%s']";


    @FindBy(css = "#collection-add-question-bank")
    private WebElement addQuestionBankOption;

    @FindBy(css = "#collection-add-assessment")
    private WebElement addTestQuizOption;

    @FindBy(css = "a[class='action-edit-template-assessment-questions sExtlink-processed']")
    private WebElement editQuestionQuizResource;

    @FindBy(css = "a[class='action-delete  sExtlink-processed popups-processed']")
    private WebElement deleteQuizResource;

    @FindBy(css = ".messages .message-text")
    private WebElement messages;

    @FindBy(css = "#library-wrapper div.messages-container")
    private WebElement messageContainer;


    public void clickAddResourcesButton() {
        WebElement addResourceButton = driver.findElement(By.xpath(ADD_RESOURCE_ACTIONS_BUTTON));
        action.click(addResourceButton);
    }

    public AddQuestionBankResourcePopup clickAddQuestionBankResource() {
        clickAddResourcesButton();
        action.click(addQuestionBankOption);
        return new AddQuestionBankResourcePopup();
    }

    public AddTestQuizResourcePopup clickAddTestQuizResource() {
        clickAddResourcesButton();
        action.click(addTestQuizOption);
        return new AddTestQuizResourcePopup();
    }

    public DeleteResourcePopup clickRemoveResource(final String resourceName) {

        WebElement resourceActionsButton = driver.findElement(By.xpath(String.format(RESOURCE_ACTIONS_BUTTON,
                resourceName)));
        WebElement resourceActionsDeleteOption =
                driver.findElement(By.xpath(String.format(RESOURCE_ACTIONS_DELETE_OPTION, resourceName)));
        action.click(resourceActionsButton);
        action.click(resourceActionsDeleteOption);
        return new DeleteResourcePopup();

    }

    public boolean resourceItemExist(final String resourceName) {
        try {
           driver.findElement(By.xpath(String.format(RESOURCE_ITEM, resourceName))).getText();
           return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(messages));
        return messages.getText();
    }

    public void waitForMessageContainerDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#library-wrapper div"
                + ".messages-container")));
    }

    private void clickResourceActionsButton(final String resourceName) {
        WebElement resourceActionsButton = driver.findElement(By.xpath(String.format(RESOURCE_ACTIONS_BUTTON,
                resourceName)));
        action.click(resourceActionsButton);
    }

    public EditAssessmentQuestions clickEditQuestionsQuizResource(final String resourceName) {
        clickResourceActionsButton(resourceName);
        action.click(editQuestionQuizResource);
        return new EditAssessmentQuestions();
    }

    public DeleteResourcePopup clickDeleteQuiz(final String resourceName) {
        clickResourceActionsButton(resourceName);
        action.click(deleteQuizResource);
        return new DeleteResourcePopup();

    }

}
