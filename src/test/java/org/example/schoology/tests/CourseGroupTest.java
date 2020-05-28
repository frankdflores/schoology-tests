package org.example.schoology.tests;

import org.example.schoology.pages.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CourseGroupTest {

    @Test
    public void editCourse() {
        Login login = new Login();
        Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
        SubMenu subMenu = home.clickMenu("Groups");
        Groups groups = subMenu.clickMyGroupsLink();
        CreateGroupPopup createGroupPopup = groups.clickCreateGroupButton();

        String courseName = "Test Group";

        Map<String, String> groupMap = new HashMap<>();
        groupMap.put("name", courseName);
        groupMap.put("description", "Description");
        groupMap.put("privacy", "group");
        groupMap.put("access", "open");
        groupMap.put("category", "General");
        createGroupPopup.create(groupMap);
    }

}

