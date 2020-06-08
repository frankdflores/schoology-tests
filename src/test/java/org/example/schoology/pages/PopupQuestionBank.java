package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class PopupQuestionBank {
    private WebDriver driver;

    private WebDriverWait wait;

    @FindBy(css = "#edit-title")
    private WebElement nameField;

    @FindBy(css = "#edit-description")
    private WebElement descriptionField;

    @FindBy(css = "#edit-enable-tracking")
    private WebElement enableCheckBox;

    @FindBy(css = ".popups-box #edit-submit")
    private WebElement submitButton;

    @FindBy(css = ".popup-messages-wrapper div[style*=\"display: none;\"]")
    private WebElement popupMessages;

    public PopupQuestionBank(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    private void fill(Map<String, String> groupMap) {
        Map<String, Step> stepMap = new HashMap<>();
        stepMap.put("name", () -> setName(groupMap.get("name")));
        stepMap.put("description", () -> setDescription(groupMap.get("description")));
        stepMap.put("enableQuestionTracking", ()
                -> clickEnableQuestionTrackingCheckBox(groupMap.get("enableQuestionTracking")));

        for (String keyField : groupMap.keySet()) {
            stepMap.get(keyField).execute();
        }
    }

    public Resources createQuestionBank(Map<String, String> QuestionBank) {
        fill(QuestionBank);
        submitButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".popup-messages-wrapper>div[style*=\"display: none;\"]")));
        return new Resources(driver);
    }

    public void setName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void setDescription(String description) {
        descriptionField.clear();
        descriptionField.sendKeys(description);
    }

    public void clickEnableQuestionTrackingCheckBox(String check) {
        if (check.equals("True")) {
            enableCheckBox.click();
        }
    }
}
