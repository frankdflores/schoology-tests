package org.example.schoology.tests;

import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.groups.CreateGroupPopup;
import org.example.schoology.pages.groups.Groups;
import org.example.schoology.pages.groups.GroupsSubMenu;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GroupsTest {
    Login login;

    @Test
    public void createGroup() {

        // Test Data
        Map<String, String> groupMap = new HashMap<>();
        groupMap.put("name", "Test Group");
        groupMap.put("description", "Description");
        groupMap.put("privacy", "School");
        groupMap.put("access", "Open");
        groupMap.put("category", "General");


        login = new Login();
        Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
        GroupsSubMenu groupsSubMenu = home.clickGroupsMenu();
        Groups groups = groupsSubMenu.clickMyGroupsLink();
        CreateGroupPopup createGroupPopup = groups.clickCreateGroupButton();
        createGroupPopup.create(groupMap);
    }
}
