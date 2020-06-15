package org.example.schoology.pages;

import org.example.schoology.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GroupPage extends AbstractPage {

   // private final By cssGroupProfile = By.cssSelector("#s-update-create-form");

    @FindBy(css= "#s-update-create-form")
    private WebElement updateCreateFormPost;

    public GroupPage() {
        wait.until(ExpectedConditions.visibilityOf(updateCreateFormPost));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(cssGroupProfile));
    }
}
