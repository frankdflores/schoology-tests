package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Groups {

    public static final String GROUP_ACTIONS_BUTTON = "//a[text()='%s']/ancestor::li//div[@class='action-links-unfold ']";
    public static final String GROUP_ACTIONS_EDIT_BUTTON = "//a[text()='%s']/ancestor::li//li[@class='action-edit']";

    private WebDriver driver;

    @FindBy(css = "a.create-group")
    private WebElement createGroupButton;

    @FindBy(css = ".messages .message-text")
    private WebElement messages;

    public Groups(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateGroupPopup clickCreateGroupButton(){
        createGroupButton.click();
        return new CreateGroupPopup(driver);

    }

    public EditGroupPopup clickEditGroup (String groupName){
        //driver.findElement(By.xpath(String.format(GROUP_ACTIONS_BUTTON, groupName))).click();

        WebElement groupActionsButton = driver.findElement(By.xpath(String.format(GROUP_ACTIONS_BUTTON, groupName)));
        WebElement groupActionsEditButton = driver.findElement(By.xpath(String.format(GROUP_ACTIONS_EDIT_BUTTON, groupName)));

        // Scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", groupActionsButton);

        groupActionsButton.click();
        groupActionsEditButton.click();
        return new EditGroupPopup(driver);

    }

    public String getMessage(){
        return messages.getText();
    }

}
