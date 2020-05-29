package org.example.schoology.tests;

import org.example.schoology.pages.Courses;
import org.example.schoology.pages.CreateCoursePopup;
import org.example.schoology.pages.CreateGroupPopup;
import org.example.schoology.pages.Groups;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.SubMenu;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GroupsTest {

    @Test
    public void newGroup() {
        Login login = new Login();
        Home home = login.loginAs("jacky.rosales84@gmail.com", "Control123");
        SubMenu subMenu = home.clickMenu("Groups");
        Groups groups = subMenu.clickMyGroupsLink();
        CreateGroupPopup createGroupPopup = groups.clickCreateGroupBtn();

        String groupName = "Test Group";

        Map<String, String> groupMap = new HashMap<>();
        groupMap.put("name", groupName);
        groupMap.put("description", "test group description");
        groupMap.put("privacy", "School");
        groupMap.put("access", "Invite Only");
        groupMap.put("category", "General");
        createGroupPopup.create(groupMap);
    }
}