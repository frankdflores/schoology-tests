package org.example.schoology.pages;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateQuestionBankPopup extends AbstractResourceQuestionBankPopup {


    public Resources CreateQuestionBank(Map<String, String> resourceQuestionMap) {
        fill(resourceQuestionMap);
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(messageClose));
        messageClose.click();

        return new Resources();
         }


}