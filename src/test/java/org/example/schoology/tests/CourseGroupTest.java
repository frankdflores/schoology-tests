package org.example.schoology.tests;

import org.example.schoology.pages.*;
import org.junit.Test;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class CourseGroupTest {

    public static final String PREFIX_AT = "AT_";
    @Test
    public void editCourse() {
        // Given
        Login login = new Login();
        Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
        SubMenu subMenu = home.clickMenu("Groups");
        Groups groups = subMenu.clickMyGroupsLink();
        CreateGroupPopup createGroupPopup = groups.clickCreateGroupButton();

        String groupName = PREFIX_AT + "Test Group" + System.currentTimeMillis();

        Map<String, String> groupMap = new HashMap<>();
        groupMap.put("name", groupName);
        groupMap.put("description", "Description");
        groupMap.put("privacy", "group");
        groupMap.put("access", "open");
        groupMap.put("category", "General");
        createGroupPopup.create(groupMap);

        //When
        subMenu = home.clickMenu("Groups");
        groups = subMenu.clickMyGroupsLink();
        EditGroupPopup editGroupPopup = groups.clickEditGroup(groupName);
        groupMap = new HashMap<>();
        groupMap.put("name", groupName);
        groupMap.put("description", "Description updated");
        groups = editGroupPopup.edit(groupMap);

        //then
        Assert.assertEquals(groupName + " has been saved.", groups.getMessage());
    }

}

