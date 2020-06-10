package org.example.schoology.pages.resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public abstract class AddResourcePopupAbstract {

    @FindBy(css = "form[id*='add-folder-form'] #edit-submit")
    protected WebElement submitButton;

    protected WebDriver driver;

    public AddResourcePopupAbstract(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public abstract MyResources addResource(Map<String, String> resourceMap);
}
