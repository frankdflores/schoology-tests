package org.example.schoology.pages;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAssessmentQuestions extends AbstractPage {

    @FindBy(css = "div[class='action-links-unfold ']")
    private WebElement assessmentAddQuestionButton;

    @FindBy(css = "a[class='schoology-back-to-resources-link sExtlink-processed']")
    private WebElement backToResourcesLink;

    public static final String ADD_QUESTION_MULTIPLE_CHOICE = "//ul[@class='action-links "
            + "component-list']/descendant::a[contains(@href,'multiple_choice')]";
    public static final String QUESTION_BY_NAME = "//p[text()='%s']";

    public void clickAddQuestionButton() {
        action.click(assessmentAddQuestionButton);
        //wait.until(ExpectedConditions.elementToBeClickable(assessmentAddQuestionButton));
        //assessmentAddQuestionButton.click();
    }

    public MultipleChoiceQuestion clickAddQuestionMultipleChoice() {
        clickAddQuestionButton();
        WebElement multipleChoiceQuestion = driver.findElement(By.xpath(String.format(ADD_QUESTION_MULTIPLE_CHOICE)));
        action.click(multipleChoiceQuestion);
        return new MultipleChoiceQuestion();
    }

    public Resources goToBackResources() {
        action.click(backToResourcesLink);
        return new Resources();
    }

    public boolean questionItemExist(final String questionItem) {
        try {
            driver.findElement(By.xpath(String.format(QUESTION_BY_NAME, questionItem))).getText();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
