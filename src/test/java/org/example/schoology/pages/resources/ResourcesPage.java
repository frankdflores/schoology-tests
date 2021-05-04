package org.example.schoology.pages.resources;

import org.example.schoology.pages.ViewList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Veronica Prado
 */
public class ResourcesPage extends ViewList {
    @FindBy(css = ".collection-item-gear")
    private WebElement gearOptions;

    @FindBy(css = "#toolbar-add div")
    private WebElement toolBarAddResources;

    @FindBy(className = "message-text")
    private WebElement MessageResource;

    public void clickAddResourcesButton() {
        action.click(toolBarAddResources);
    }

    public CreatePageResourcePopup selectAddResourceOption(String resourceOption){
        action.jsClick(driver.findElement(By.xpath(String.format("//li/a[text()='%s']", resourceOption))));
        return new CreatePageResourcePopup();
    }

    public CreatePageResourcePopup editResource(String resourceName){
        WebElement row = driver.findElement(By.xpath(String.format("//td[@class='collection-item-title' and contains(string(), '%s')]/parent::*]",
                resourceName)));
        action.scrollTo(row);
        action.jsClick(row.findElement(By.cssSelector("collection-item-gear")));
        return new CreatePageResourcePopup();
    }
}
