package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Groups extends AbstractPage {

    public static final String GROUP_ACTIONS_BUTTON = "//a[text()='%s']/ancestor::li//div[@class='action-links-unfold ']";
    public static final String GROUP_ACTION_EDIT_GROUP_BUTTON = "//a[text()='%s']/ancestor::li//li[@class='action-edit']";

    private static final String XPATH_RESOURCE_BY_NAME = ("//a[text()='%s']");

    @FindBy(css = "a.create-group" )
    private WebElement createGroupButton;

    @FindBy(css = ".messages .message-text")
    private WebElement messages;

    public CreateGroupPopup clickCreateGroupButton(){
        createGroupButton.click();
        return new CreateGroupPopup();
    }

    public EditGroupPopup clickEditGroup(String groupName) {
        driver.findElement(By.xpath(String.format(GROUP_ACTIONS_BUTTON, groupName))).click();
        WebElement actionEdit = driver.findElement(By.xpath(String.format(GROUP_ACTION_EDIT_GROUP_BUTTON, groupName)));
        actionEdit.click();
        return new EditGroupPopup();
    }

    public String getMessage(){
        return messages.getText();
    }

    public String getGroupByName(String groupName){
        return driver.findElement(By.xpath(String.format(XPATH_RESOURCE_BY_NAME, groupName))).getText();
    }
}
