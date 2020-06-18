package org.example.schoology.pages.resources;

import org.example.schoology.pages.ViewList;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class Resources extends ViewList {
    @FindBy(xpath = "//span[text()='Add Resources']/parent::div")
    private WebElement addResourcesButton;

    //div.popups-body div.submit-buttons input[type='submit']
    @FindBy(css = "div.popups-body > form > div input#edit-submit")
    private WebElement deleteConfirmationButton;

    @FindBy(css = "div.message-text")
    private WebElement messageField;

    public void clickAddResources() {
        addResourcesButton.click();
    }

    public AddQuestionBankPopup selectAddResourceOption(String resourceOption) {
        driver.findElement(By.cssSelector(String.format("li#collection-add-%s", resourceOption))).click();
        return new AddQuestionBankPopup();
    }

    public void clickOnResourceActions(String resourceName) {
        //a[text()='Delete' and class='action-delete']
        //css -> ul[style="display: block;"] li.action-%s (delete)
        String xpath = String.format("//a[text()='%s']/ancestor-or-self::tr/descendant::td[@class='collection-item-gear']/child::div", resourceName);

        driver.findElement(By.xpath(xpath)).click();
    }

    public void deleteAction() {
        clickOnResourceOption("delete");
        deleteConfirmationButton.click();
    }

    private void clickOnResourceOption(String resourceOption) {
        String css = String.format("ul[style=\"display: block;\"] li.action-'%s'", resourceOption);
        driver.findElement(By.cssSelector(css)).click();
    }
}
