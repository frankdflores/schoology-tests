package org.example.schoology.pages;

import org.example.schoology.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Groups extends AbstractPage {

    public static final String GROUP_ACTIONS_BUTTON = "//a[text()='%s']/ancestor::li//div[@class='action-links-unfold ']";
    public static final String GROUP_ACTIONS_EDIT_BUTTON = "//a[text()='%s']/ancestor::li//li[@class='action-edit']";
    public static final String GROUP_BY_NAME = "//a[text()='%s']";

    @FindBy(css = "a.create-group")
    private WebElement createGroupButton;

    @FindBy(css = ".messages .message-text")
    private WebElement messages;

    public CreateGroupPopup clickCreateGroupBtn() {
        createGroupButton.click();
        return new CreateGroupPopup();
    }

    public EditGroupPopup clickEditGroup(String groupName) {
        WebElement groupActionsButton = driver.findElement(By.xpath(String.format(GROUP_ACTIONS_BUTTON, groupName)));
        WebElement editGroup = driver.findElement(By.xpath(String.format(GROUP_ACTIONS_EDIT_BUTTON,groupName)));

        // Scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", groupActionsButton);

        groupActionsButton.click();
        editGroup.click();
        return new EditGroupPopup();

    }

    public String getMessage() {
        return messages.getText();
    }

    public String getGroupByName(String groupName) {
        return driver.findElement(By.xpath(String.format(GROUP_BY_NAME, groupName))).getText();
    }

}
