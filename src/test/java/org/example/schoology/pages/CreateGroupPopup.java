package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.example.schoology.pages.GroupPage;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.HashMap;
import java.util.Map;

public class CreateGroupPopup extends AbstractGroupPopup {

    public CreateGroupPopup(WebDriver driver) {
        super(driver);
    }

    public GroupPage create (Map<String, String> groupMap){
        fill (groupMap);
        submitButton.click();
        return new GroupPage(driver);
    }
}
