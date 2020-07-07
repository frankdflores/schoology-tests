package org.example.schoology.pages.resources;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.Resources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteResourcePopup extends AbstractPage {

    private WebDriver driver;

    @FindBy(css = "input[value='Delete']")
    private WebElement deleteButton;

    public Resources clickDeleteButton() {
        action.click(deleteButton);
        return new Resources();
    }
}
