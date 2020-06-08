package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteQuestionBank {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(css = "input[id='edit-submit'][value='Delete']")
    protected WebElement submitButton;

    @FindBy(css = ".popup-messages-wrapper div[style*=\"display: none;\"]")
    private WebElement popupMessages;

    public DeleteQuestionBank(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public Resources delete() {
        submitButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".popup-messages-wrapper>div")));
        return new Resources(driver);
    }
}
