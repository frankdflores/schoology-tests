package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditAssessmentQuestions extends AbstractPage {

    @FindBy(css = "div[class='action-links-unfold ']")
    private WebElement assessmentAddQuestionButton;

    @FindBy(css = "a[class='schoology-back-to-resources-link sExtlink-processed']")
    private WebElement backToResourcesLink;

    public static final String ADD_QUESTION_MULTIPLE_CHOICE = "//ul[@class='action-links component-list']/descendant::a[contains(@href,'multiple_choice')]";


    public void clickAddQuestionButton(){
        wait.until(ExpectedConditions.elementToBeClickable(assessmentAddQuestionButton));
        assessmentAddQuestionButton.click();
    }

    public MultipleChoiceQuestion clickAddQuestionMultipleChoice(){
        clickAddQuestionButton();
        WebElement multipleChoiceQuestion = driver.findElement(By.xpath(String.format(ADD_QUESTION_MULTIPLE_CHOICE)));
        multipleChoiceQuestion.click();
        return new MultipleChoiceQuestion();
    }
    public Resources goToBackResources(){
        backToResourcesLink.click();
        return new Resources();
    }

}
