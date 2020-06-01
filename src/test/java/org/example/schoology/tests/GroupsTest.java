package org.example.schoology.tests;

import org.example.schoology.pages.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GroupsTest {

    @Test
    public void editCourse() {
        Login login = new Login();
        Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
        home.cancelVerificationAccount();
        SubMenu subMenu = home.clickMenu("Groups");
        Groups groups = subMenu.clickMyGroupsLink();

        // create group
        Map<String, String> groupMap = new HashMap<String, String>();
        groupMap.put("name", "Group test");
        groupMap.put("description", "Group test");
        groupMap.put("privacy", "School");
        groupMap.put("access", "Invite Only");
        groupMap.put("category", "Select a category");

        CreateGroupPopup popup = groups.clickCreateGroupButton();
        groups = popup.fillInTheFieldsAndCreate(groupMap);
        groups.endProcess();
    }

}
