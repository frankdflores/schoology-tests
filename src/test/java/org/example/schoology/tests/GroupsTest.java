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
        SubMenu subMenu = home.clickMenu("Groups");
        Groups groups = subMenu.clickMyGroupsLink();
        CreateGroupPopup createGroupPopup = groups.clickCreateGroupButton();
        //Course course = new Course();
        String groupName = "Test Group";

        Map<String, String> groupMap = new HashMap<>();
        groupMap.put("name", groupName);
        groupMap.put("description", "this is a description");
        groupMap.put("privacy", "Group");
        groupMap.put("access", "Open");
        groupMap.put("category", "Career Groups");
        //home = createGroupPopup.create(groupMap);
        //https://app.schoology.com/group/2561240275
        //subMenu = home.clickMenu("Groups");
        //groups = subMenu.clickGroupLink();


    }
}