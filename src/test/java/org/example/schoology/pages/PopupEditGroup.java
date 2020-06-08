package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;

import java.util.Map;

public class PopupEditGroup extends AbstractGroupPopup{

    public PopupEditGroup(WebDriver driver){
        super(driver);
    }

    public Groups fillInTheFieldsAndEdit(Map<String, String> groupMap) {
        fill(groupMap);
        submitButton.click();
        return new Groups(driver);
    }
}
