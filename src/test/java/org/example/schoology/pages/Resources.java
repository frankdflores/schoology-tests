package org.example.schoology.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class Resources {

    public static final String RESOURCE_ACTIONS_BUTTON = "//a[text()='%s']/ancestor::tr//div[@class='action-links-unfold ']";
    public static final String RESOURCE_NAME = "//a[text()='%s']";
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#toolbar-add .action-links-unfold")
    private WebElement addResourcesDropdown;

    @FindBy(css = "ul[style=\"display: block;\"] .action-collection-template-delete")
    private WebElement deleteResource;

    @FindBy(css = ".messages .message-text")
    private WebElement messages;

    public Resources(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public Map <String, Object> allResources() {
        Map<String, Object> resources = new HashMap<String, Object>();
        resources.put("Add Question Bank", new AddQuestionBankPopup(driver));

        return resources;
    }

    public Object addResource(String resourceName) {
//        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(messages)));
        addResourcesDropdown.click();
        WebElement resourceOption = driver.findElement(By.xpath(String.format(RESOURCE_NAME, resourceName)));
        resourceOption.click();

        return allResources().get(resourceName);
    }

    public DeleteResourcePopup clickDeleteResource(String resourceName){
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(messages)));
        WebElement resourceActionButton = driver.findElement(By.xpath(String.format(RESOURCE_ACTIONS_BUTTON, resourceName)));

        // Scroll
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", resourceActionButton);

        resourceActionButton.click();
        deleteResource.click();
        return new DeleteResourcePopup(driver);
    }

    public String getResourceName(String resourceName){
        try {
            return driver.findElement(By.xpath(String.format(RESOURCE_NAME, resourceName))).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public String getMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(messages));
        return messages.getText();
    }
}
