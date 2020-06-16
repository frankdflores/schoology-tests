package org.example.schoology.pages;

import java.util.Map;

public class CreateGroupPopup extends AbstractGroupPopup {

    public GroupPage create(Map<String, String> groupMap){
        fill(groupMap);
        submitButton.click();
        return new GroupPage();
    }
}
