package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Resources {
    public static final String QUESTION_BANK_ACTION_BUTTON = "//a[text()='%s']/ancestor::tr//div[@class='action-links-unfold ']";
    public static final String SELECT_ACTION = "//a[text()='%s']/ancestor::tr//ul//li[contains(@class,'action-delete')]";
    public static final String RESOURCE_NAME = "//a[text()='%s']";

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "#toolbar-add")
    WebElement addNewResourceButton;

    @FindBy(css = "#collection-add-question-bank")
    WebElement addNewQuestionBank;

    @FindBy(css = ".popups-box #edit-submit")
    private WebElement deleteButton;

    @FindBy(css = ".messages .message-text")
    private WebElement messages;

    public Resources(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void addResource(){
        addNewResourceButton.click();
    }

    public CreateQuestionBankPopup addQuestionBank(){
        addNewQuestionBank.click();
        return new CreateQuestionBankPopup(driver);
    }

    public void clickEditQuestionBank(String questionBankName){

        driver.findElement(By.xpath(String.format(QUESTION_BANK_ACTION_BUTTON, questionBankName))).click();
        driver.findElement(By.xpath(String.format(SELECT_ACTION, questionBankName))).click();
        deleteButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".popup-messages-wrapper>div")));

    }

    public String getMessage() {
        return messages.getText();
    }

    public String getResourceName(String resourceName){
        try {
            return driver.findElement(By.xpath(String.format(RESOURCE_NAME, resourceName))).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }


}
