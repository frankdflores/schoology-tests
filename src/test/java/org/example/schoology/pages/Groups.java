package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Groups {

    public static final String GROUP_ACTIONS_BUTTON = "//a[text()='%s']/ancestor::li//div[@href='#']";
    public static final String SELECT_ACTIONS ="//a[text()='%s']/ancestor::li//ul//li[@class='action-edit']";
    private WebDriver driver;

    @FindBy(css = "a.create-group")
    private WebElement CreateGroupButton;

    public Groups(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PopupCreateGroup clickCreateGroupButton(){
        CreateGroupButton.click();
        return new PopupCreateGroup(driver);
    }

    public PopupCreateGroup clickEditGroup(String groupName) {
        driver.findElement(By.xpath(String.format(GROUP_ACTIONS_BUTTON, groupName))).click();
        driver.findElement(By.xpath(String.format(SELECT_ACTIONS, groupName))).click();
        return new PopupCreateGroup(driver);
    }

}
