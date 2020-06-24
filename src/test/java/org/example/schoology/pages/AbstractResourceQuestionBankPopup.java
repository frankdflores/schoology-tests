package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class AbstractResourceQuestionBankPopup extends AbstractPage {
    @FindBy(css = "#edit-title")
    private WebElement questionTitleTextField;

    @FindBy(css = "#edit-description")
    private WebElement descriptionTextField;

    @FindBy(css = "#edit-enable-tracking" )
    private WebElement trackingAreaDropDown;

    @FindBy(xpath = "//input[@value='Create' and @id='edit-submit']" )
    protected WebElement submitButton;

    @FindBy(css = ".messages-close-btn" )
    protected WebElement messageClose;

    public void fill(Map<String, String> resourceQuestionMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setName(resourceQuestionMap.get("name")));
        stepsMap.put("description", () -> setDescription(resourceQuestionMap.get("description")));
        stepsMap.put("tracking", () -> setTracking(resourceQuestionMap.get("tracking")));

        for (String keyField : resourceQuestionMap.keySet()) {
            stepsMap.get(keyField).execute();
        }


    }
    public void setName(String name) {
        questionTitleTextField.sendKeys(name);
    }

    private void setDescription(String description) {
        descriptionTextField.sendKeys(description);
    }

    private void setTracking(String tracking) {
        if(tracking.equalsIgnoreCase("True")){
            trackingAreaDropDown.click();
        }
    }
}
