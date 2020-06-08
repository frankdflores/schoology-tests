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

public class QuestionBankPopup {
    private final WebDriver driver;

    private final WebDriverWait wait;

    @FindBy(css = "#edit-title")
    private WebElement nameField;

    @FindBy(css = "#edit-description")
    private WebElement descriptionField;

    @FindBy(css = "#edit-enable-tracking")
    private WebElement enableQuestionTrackingCheckbox;

    @FindBy(css = ".popups-box #edit-submit")
    private WebElement createButton;

    public QuestionBankPopup(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    private void fill(Map<String, String> questionBankMap) {
        Map<String, Step> stepMap = new HashMap<>();
        stepMap.put("name", () -> setName(questionBankMap.get("name")));
        stepMap.put("description", () -> setDescription(questionBankMap.get("description")));
        stepMap.put("enableQuestionTracking", ()
                -> checkEnableQuestionTracking(questionBankMap.get("enableQuestionTracking")));

        for (String keyField : questionBankMap.keySet()) {
            stepMap.get(keyField).execute();
        }
    }

    public Resources addQuestionBank(Map<String, String> questionBank) {
        fill(questionBank);
        createButton.click();
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

    public void checkEnableQuestionTracking(String check) {
        if (check.equals("True")) {
            enableQuestionTrackingCheckbox.click();
        }
    }
}