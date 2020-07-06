package org.example.schoology.pages.groups;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class CreateGroupPopup extends AbstractGroupPopup {

    public GroupPage create(Map<String, String> groupMap){
        fill(groupMap);
        action.click(submitButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".form-submit")));
        return new GroupPage();
    }
}
