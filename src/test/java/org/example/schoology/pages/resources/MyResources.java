package org.example.schoology.pages.resources;

import org.example.schoology.pages.DeletePopup;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import static org.example.schoology.pages.Login.DEFAULT_IMPLICIT_TIMEOUT;
import static org.example.schoology.pages.Login.MIN_IMPLICIT_TIMEOUT;

public class MyResources {

    public static final String RESOURCES_ACTIONS_BUTTON = "//a[text()='%s']/ancestor::tr//div[@class='action-links-unfold ']/span";
    private static final String RESOURCE_LINK = "a[href*='add_%s']";

    @FindBy(xpath = "//div[ul[@id='toolbar-add-list']]")
    private WebElement addResources;

    @FindBy(css = "ul[style='display: block;'] .action-delete")
    private WebElement deleteResource;

    @FindBy(css = ".message-text")
    private WebElement messageText;

    @FindBy(css = ".messages-close-btn")
    private WebElement closeMessageButton;


    private WebDriver driver;

    private WebDriverWait wait;

    public MyResources(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    private AddResourcePopupAbstract getAddResourcePopup(final String resourceType) {
        HashMap<String, Supplier<AddResourcePopupAbstract>> addResourcePopupMap = new HashMap<>();
        addResourcePopupMap.put("question bank", () -> new AddQuestionBankResourcePopup(driver));
        return addResourcePopupMap.get(resourceType).get();
    }

    public AddResourcePopupAbstract clickAddResources(final String resourceType) {
        String resourceTypeModified = resourceType.toLowerCase().replaceAll(" ", "_");
        addResources.click();
        driver.findElement(By.cssSelector(String.format(RESOURCE_LINK, resourceTypeModified))).click();
        return getAddResourcePopup(resourceType);
    }

    public DeletePopup deleteResource(final String resourceName) {
        WebElement resourcesActionsButton = driver.findElement(By.xpath(String.format(RESOURCES_ACTIONS_BUTTON, resourceName)));
//
//        // Scroll
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", resourcesActionsButton);

        resourcesActionsButton.click();
        deleteResource.click();
        return new DeletePopup(driver);
    }

    public String getMessage() {
        wait.until(ExpectedConditions.visibilityOf(messageText));
        return messageText.getText();
    }

    public boolean isResourceDisplayed(final String resourceName) {
        try {
//			// Changing timeout
            driver.manage().timeouts().implicitlyWait(MIN_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
            driver.findElement(By.xpath(String.format(RESOURCES_ACTIONS_BUTTON, resourceName)));
            return true;
        } catch (NoSuchElementException e) {
            // nothing.
        } finally {
//			// Restore timeout
            driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        }
        return false;
    }

    public void closeMessage() {
        closeMessageButton.click();
    }
}
