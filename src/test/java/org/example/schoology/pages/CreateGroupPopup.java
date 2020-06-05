package org.example.schoology.pages;


import org.openqa.selenium.WebDriver;
import java.util.Map;

public class CreateGroupPopup extends AbstractGroupPopup {

    public CreateGroupPopup(WebDriver driver) {
        super(driver);
    }

    public GroupPage create(Map<String, String> groupMap){
        fill(groupMap);
        submitButton.click();
        return new GroupPage(driver);
    }
}