package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Resources {

    private WebDriver driver;
    private WebDriverWait wait;

    public static final String QUESTION_ACTIONS_BUTTON = "//a[text()='%s']/ancestor::td /following-sibling::td//div[@class='action-links-unfold ']";
    public static final String QUESTION_ACTIONS_EDIT_BUTTON = "//a[text()='%s']/ancestor::td /following-sibling::td//ul/li[@class='action-collection-template-edit action-edit']";
    public static final String QUESTION_ACTIONS_DELETE_BUTTON = "//a[text()='%s']/ancestor::td /following-sibling::td/div/ul/li[@class='action-collection-template-delete action-delete ']";

    @FindBy(css = "#popups-0")
    private WebElement updateTableResources;

    public Resources(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);

        //wait.until(ExpectedConditions.invisibilityOf(updateTableResources));
    }

    public ResourcesDropDown clickAddResourcesBtn() {
        driver.findElement(By.xpath("//div[@id='toolbar-add-wrapper']")).click();
        return new ResourcesDropDown(driver);
    }

    public DeleteQuestionBank clickEditQuestion(String questionName) {
        WebElement questionActionsButton = driver.findElement(By.xpath(String.format(QUESTION_ACTIONS_BUTTON, questionName)));
        WebElement editQuestion = driver.findElement(By.xpath(String.format(QUESTION_ACTIONS_EDIT_BUTTON,questionName)));

        // Scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", questionActionsButton);

        questionActionsButton.click();
        editQuestion.click();
        return new DeleteQuestionBank(driver);
    }

    public DeleteQuestionBank clickDeleteQuestion(String questionName) {
        WebElement questionActionsButton = driver.findElement(By.xpath(String.format(QUESTION_ACTIONS_BUTTON, questionName)));
        WebElement deleteQuestion = driver.findElement(By.xpath(String.format(QUESTION_ACTIONS_DELETE_BUTTON,questionName)));

        // Scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", questionActionsButton);

        questionActionsButton.click();
        deleteQuestion.click();
        return new DeleteQuestionBank(driver);
    }
}
