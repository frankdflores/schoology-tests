package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class MultipleChoiceQuestion extends AbstractPage {

    @FindBy(css = ".mceContentBody")
    private WebElement questionTextField;

    @FindBy(css="#edit-add-choice")
    private WebElement addButton;

    @FindBy(css="#edit-remove-blanks")
    private WebElement removeBlanksButton;

    @FindBy(css="#edit-submit")
    private WebElement createQuestionButton;

    @FindBy(css="a[class='schoology-back-to-resources-link sExtlink-processed']")
    private WebElement backToResourcesLink;


    public static final String MULTIPLE_CHOICE = "#edit-multiple-choice-choice-%s-text";
    public static final String MULTIPLE_CHOICE_IS_ANSWER = "#edit-multiple-choice-choice-%s-is-answer";


    private void setMultipleChoiceQuestion(String question) {
        driver.switchTo().frame("edit-title_ifr");
        questionTextField.click();
        questionTextField.sendKeys(question);
        driver.switchTo().defaultContent();
    }

    private void setChoiceAnswerText(String answer, String index){
        WebElement choiceAnswerTextField = driver.findElement(By.cssSelector(
                String.format(MULTIPLE_CHOICE, index)));
        choiceAnswerTextField.click();
        choiceAnswerTextField.sendKeys(answer);

    }

    private void selectCorrectChoiceAnswer(String index){
        Integer indexAnswer = Integer.parseInt(index) - 1;
        WebElement choiceAnswerCheckBox = driver.findElement(By.cssSelector(String.format(MULTIPLE_CHOICE_IS_ANSWER, indexAnswer)));
        choiceAnswerCheckBox.click();

    }

    private void removeBlankQuestions(){
        removeBlanksButton.click();
    }

    private void fillMultipleChoiceQuestion(Map<String, String> questionMap) {
        Integer numberofQuestions = Integer.parseInt(questionMap.get("number_of_options"));
        //questionMap.remove("number_of_options");

        Map<String, Step> stepMap = new HashMap<>();
        stepMap.put("question", () -> setMultipleChoiceQuestion(questionMap.get("question")));

        for(int i=0; i<numberofQuestions; i++ ){
            String choice = "choice_" + i;
            String index = String.valueOf(i);
            stepMap.put(choice, () -> setChoiceAnswerText(questionMap.get(choice), index));
        }

        stepMap.put("is_answer", () -> selectCorrectChoiceAnswer(questionMap.get("is_answer")));

        for (String keyField : stepMap.keySet()) {
            stepMap.get(keyField).execute();
        }
    }

    public void addMultipleChoiceQuestion(Map<String, String> questionMap){
        fillMultipleChoiceQuestion(questionMap);
        removeBlankQuestions();
        createQuestionButton.click();
    }

    public void backToResourcesPage(){
        backToResourcesLink.click();
    }

}
