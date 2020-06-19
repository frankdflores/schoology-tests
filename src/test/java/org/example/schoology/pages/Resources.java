package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Resources extends AbstractPage {
    public static final String ACTIONS_BUTTON = "//a[text()='%s']/ancestor::tr//div[@href='#']";
    public static final String SELECT_ACTION = "//a[text()='%s']/ancestor::tr//ul//li[contains(@class,'action-delete')]";
    public static final String RESOURCE_BY_NAME = "//a[text()='%s']";
//    private final WebDriverWait wait;
//
//    private final WebDriver driver;

    @FindBy(css = "#collection-add-question-bank")
    private WebElement addQuestionBankOption;

    @FindBy(css = ".popups-box #edit-submit")
    private WebElement deleteButton;

    @FindBy(css = ".messages .message-text")
    private WebElement messages;


    public void clickAddResourcesComboBox() {
        driver.findElement(By.xpath("//div[@id='toolbar-add']/child::div")).click();
    }

    public QuestionBankPopup selectAddQuestionBankOption() {
        addQuestionBankOption.click();
        return new QuestionBankPopup();
    }

    public void deleteResource(String name) {
        driver.findElement(By.xpath(String.format(ACTIONS_BUTTON, name))).click();
        driver.findElement(By.xpath(String.format(SELECT_ACTION, name))).click();
        deleteButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".popup-messages-wrapper>div")));
    }

    public String getMessage() {
        return messages.getText();
    }

    public boolean searchResourceByName(String resourceName) {
        try {
            driver.findElement(By.xpath(String.format(RESOURCE_BY_NAME, resourceName))).getText();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}