package org.example.schoology.pages;

import org.example.schoology.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteQuestionBank extends AbstractPage {

    @FindBy(css = "input[id='edit-submit'][value='Delete']")
    protected WebElement deleteButton;

    public Resources delete() {
        deleteButton.click();
        return new Resources();
    }
}
