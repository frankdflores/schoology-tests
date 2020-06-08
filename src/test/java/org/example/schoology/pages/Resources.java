package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Resources {

    public static final String ACTIONS_BUTTON = "//a[text()='%s']/ancestor::tr//div[@href='#']";
    public static final String SELECT_ACTION = "//a[text()='%s']/ancestor::tr//ul//li[contains(@class,'action-delete')]";
    public static final String RESOURCE_BY_NAME = "//a[text()='%s']";
    private final WebDriverWait wait;

    private WebDriver driver;

    @FindBy(css = "#collection-add-question-bank")
    private WebElement addQuestionBank;

    @FindBy(css = ".popups-box #edit-submit")
    private WebElement deleteButton;

    @FindBy(css = ".messages .message-text")
    private WebElement messages;


    @FindBy(css = ".popup-messages-wrapper div[style*=\"display: none;\"]")
    private WebElement popupMessages;

    public Resources(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void addResources() {
        driver.findElement(By.cssSelector("#toolbar-add")).click();
    }

    public QuestionBankPopup clickAddQuestionBank(){
        addQuestionBank.click();
        return new QuestionBankPopup(driver);
    }

    public void deleteResources(String name) {
        driver.findElement(By.xpath(String.format(ACTIONS_BUTTON, name))).click();
        driver.findElement(By.xpath(String.format(SELECT_ACTION, name))).click();
        deleteButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".popup-messages-wrapper>div")));
    }

    public String getMessage() {
        return messages.getText();
    }

    public boolean getResourceByName(String groupName) {
        try {
            driver.findElement(By.xpath(String.format(RESOURCE_BY_NAME, groupName))).getText();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
