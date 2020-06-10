package org.example.schoology.tests;

import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.groups.CreateGroupPopup;
import org.example.schoology.pages.groups.EditGroupPopup;
import org.example.schoology.pages.groups.Groups;
import org.example.schoology.pages.groups.GroupsSubMenu;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.example.schoology.tests.CoursesTest.PREFIX_AT;
import static org.example.schoology.tests.ResourcesTest.PREFIX_WA_YA;

public class GroupsTest {

    @Test
    public void editGroupTest() {

        // Test Data
        String groupName = PREFIX_WA_YA + "Test Group" + System.currentTimeMillis();
        Map<String, String> groupMap = new HashMap<>();
        groupMap.put("name", groupName);
        groupMap.put("description", "Description");
        groupMap.put("privacy", "School");
        groupMap.put("access", "Open");
        groupMap.put("category", "General");

        // Given
        Login login = new Login();
        Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
        GroupsSubMenu groupsSubMenu = home.clickGroupsMenu();
        Groups groups = groupsSubMenu.clickMyGroupsLink();
        CreateGroupPopup createGroupPopup = groups.clickCreateGroupButton();
        createGroupPopup.create(groupMap);

        // When
        groupsSubMenu = home.clickGroupsMenu();
        groups = groupsSubMenu.clickMyGroupsLink();
        EditGroupPopup editGroupPopup = groups.clickEditGroup(groupName);
        groupMap = new HashMap<>();
        groupMap.put("description", "Updated Description");
        groupMap.put("privacy", "School");
        groups = editGroupPopup.edit(groupMap);

        // Then
        Assert.assertEquals(groupName + " has been saved.", groups.getMessage());

        //ToDo add other validations
    }
}
