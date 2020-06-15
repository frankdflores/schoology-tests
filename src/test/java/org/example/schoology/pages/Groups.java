package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Groups extends AbstractPage {

    public static final String GROUP_ACTIONS_BUTTON = "//a[text()='%s']/ancestor::li//div[@href='#']";
    public static final String SELECT_ACTIONS = "//a[text()='%s']/ancestor::li//ul//li[@class='action-edit']";
    public static final String GROUP_BY_NAME = "//a[text()='%s']";

    @FindBy(css = "a.create-group")
    private WebElement CreateGroupButton;

    @FindBy(css = ".messages .message-text")
    private WebElement messages;

    public CreateGroupPopup clickCreateGroupButton(){
        CreateGroupButton.click();
        return new CreateGroupPopup();
    }

    public EditGroupPopup clickEditGroup(String groupName) {
        WebElement groupActionsButton = driver.findElement(By.xpath(String.format(GROUP_ACTIONS_BUTTON, groupName)));
        // Scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", groupActionsButton);

        groupActionsButton.click();
        driver.findElement(By.xpath(String.format(SELECT_ACTIONS, groupName))).click();
        return new EditGroupPopup();
    }

    public String getMessage() {
        return messages.getText();
    }

    public String getGroupByName(String groupName) {
        return driver.findElement(By.xpath(String.format(GROUP_BY_NAME, groupName))).getText();
    }

}
