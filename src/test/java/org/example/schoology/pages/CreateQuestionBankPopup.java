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

public class CreateQuestionBankPopup {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "#edit-title")
    WebElement addQuestionBankNameTextField;

    @FindBy(css = "#edit-description")
    WebElement addQuestionBankDescriptionTextArea;

    @FindBy(css = "#edit-enable-tracking")
    WebElement editEnableTrackingCheckbox;

    @FindBy(css = ".popups-box #edit-submit")
    WebElement createQuestionBankButton;

    public CreateQuestionBankPopup(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);

        PageFactory.initElements(driver, this);

    }

    public AddQuestionBankPage create(Map<String, String> addQuestionBankName){

        Map<String, Step> stepsMap = new HashMap<>();

        stepsMap.put("name", () -> setName(addQuestionBankName.get("name")));
        stepsMap.put("description", () -> setDescription(addQuestionBankName.get("description")));

        for(String keyField : addQuestionBankName.keySet()){
            stepsMap.get(keyField).execute();
        }

        editEnableTrackingCheckbox.click();

        createQuestionBankButton.submit();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".popup-messages-wrapper>div[style*=\"display: none;\"]")));

        return new AddQuestionBankPage(driver);

    }

    public void setName(String name){
        addQuestionBankNameTextField.sendKeys(name);
    }

    public void setDescription(String description){
        addQuestionBankDescriptionTextArea.sendKeys(description);
    }
}
