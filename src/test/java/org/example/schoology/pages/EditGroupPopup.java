package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;

import java.util.Map;

public class EditGroupPopup extends AbstractGroupPopup {

    public Groups fillInTheFieldsAndEdit(Map<String, String> groupMap) {
        fill(groupMap);
        submitButton.click();
        return new Groups();
    }
}
