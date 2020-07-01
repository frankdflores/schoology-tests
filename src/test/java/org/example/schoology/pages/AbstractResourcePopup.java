package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.HashMap;
import java.util.Map;

public abstract class AbstractResourcePopup extends AbstractPage {

    @FindBy(css = "#edit-title")
    private WebElement addQuestionBankNameTextField;

    @FindBy(css = "#edit-description")
    private WebElement addQuestionBankDescriptionTextField;

    @FindBy(css = "#edit-enable-tracking")
    private WebElement addQuestionBankEnableTrackingCheckBox;

    @FindBy(css = "input[value='Create']")
    protected  WebElement addQuestionBankSubmitButton;

    @FindBy(css = "#edit-template-fields-title")
    protected WebElement addTestQuizNameTextField;

    @FindBy(css = "#edit-template-fields-max-points")
    protected WebElement addTestQuizMaxPointsTextField;

    @FindBy(css = "form#s-library-collection-template-form input#edit-submit")
    protected WebElement addTestQuizSubmitButton;


    public void setNameAddQuestionBank(String name) {
        addQuestionBankNameTextField.sendKeys(name);
    }

    public void setDescriptionAddQuestionBank(String description) {
        addQuestionBankDescriptionTextField.sendKeys(description);
    }

    public void fillAddQuestionBankForm(Map<String, String> resourceMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setNameAddQuestionBank(resourceMap.get("name")));
        stepsMap.put("description", () -> setDescriptionAddQuestionBank(resourceMap.get("description")));
        stepsMap.put("enableQuestionTracking", () -> setEnableQuestionTrackingAddQuestionBank(resourceMap.get("enableQuestionTracking")));

        for (String keyField : resourceMap.keySet()) {
            stepsMap.get(keyField).execute();
        }
    }

    private void setEnableQuestionTrackingAddQuestionBank(String enableQuestionTracking) {
        switch(enableQuestionTracking) {
            case "True":
                addQuestionBankEnableTrackingCheckBox.click();
                break;
        }
    }

    public void fillAddTestQuizForm(Map<String, String> resourceMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setNameAddTestQuiz(resourceMap.get("name")));
        stepsMap.put("maxPoints", () -> setMaxPointsAddTestQuiz(resourceMap.get("maxPoints")));

        for (String keyField : resourceMap.keySet()) {
            stepsMap.get(keyField).execute();
        }
    }

    private void setNameAddTestQuiz(String name) {
        addTestQuizNameTextField.sendKeys(name);
    }

    private void setMaxPointsAddTestQuiz(String maxPoints) {
        addTestQuizMaxPointsTextField.clear();
        addTestQuizMaxPointsTextField.sendKeys(maxPoints);
    }
}
