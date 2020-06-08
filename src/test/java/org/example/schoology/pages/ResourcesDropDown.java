package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResourcesDropDown {

    private WebDriver driver;

    @FindBy(css = "li[id='collection-add-question-bank']>a")
    private WebElement addQuestionBankLink;

    public ResourcesDropDown(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateQuestionBankPopup clickAddQuestionBank() {
        addQuestionBankLink.click();
        return new CreateQuestionBankPopup(driver);

    }
}
