package org.example.schoology.tests;

import org.example.schoology.pages.Login;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.Groups;
import org.example.schoology.pages.CreateGroupPopup;
import org.example.schoology.pages.GroupPage;
import org.example.schoology.pages.EditGroupPopup;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.Assert;

public class GroupsTest {
    public static final String PREFIX_AT = "AT_";

    @Test
    public void editGroupTest() {

        //Given
        Login login = new Login();
        Home home = login.loginAs("dennis.gamboa17@hotmail.com", "P4ssw0rd123");
        //Create Groups with lambda expression and interface on demand

        SubMenu subMenu = (SubMenu) home.clickMenu("Groups");
        Groups groups = subMenu.clickMyGroupsLink();
        CreateGroupPopup createGroupPopup = groups.clickCreateGroupButton();
        String groupName = PREFIX_AT + "Test Group008" + System.currentTimeMillis();
        Map<String, String> groupMap = new HashMap<>();
        groupMap.put("name", groupName);
        groupMap.put("description", "Description08");
        groupMap.put("privacy", "Group");
        groupMap.put("access", "Open");
        groupMap.put("category", "Musical Groups");
        GroupPage groupPage = createGroupPopup.create(groupMap);


        //When
        subMenu = (SubMenu) home.clickMenu("Groups");
        groups = subMenu.clickMyGroupsLink();
        EditGroupPopup editGroupPopup = groups.clickEditGroup(groupName);
        groupMap = new HashMap<>();
        groupMap.put("name", groupName);
        groupMap.put("description", "Description");
        groupMap.put("privacy", "No One");
        groupMap.put("access", "Allow Requests");
        groupMap.put("category", "Faculty Groups");
        groups = editGroupPopup.edit(groupMap);


        //then
        Assert.assertEquals(groupName + " has been saved.", groups.getMessage());

        //home.clickMenu("Groups");
        //subMenu.clickMyGroupsLink();
    }
}
