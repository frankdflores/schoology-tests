package org.example.schoology.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;


public class CreateGroupPopup extends AbstractGroupPopup{

    public Group fillInTheFieldsAndCreate(Map<String, String> groupMap) {
        fill(groupMap);
        submitButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".form-submit")));
        return new Group();
    }
}
