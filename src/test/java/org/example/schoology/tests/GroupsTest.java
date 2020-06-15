package org.example.schoology.tests;

import org.example.schoology.pages.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GroupsTest {

    public static final String PREFIX_AT = "AT_";

    @Test
    public void editGroupTest() {

        //Given
        Login login = new Login();
        Home home = login.loginAs("LYNX_LEXX@hotmail.com", "TheTop86!");
        //Create Groups with lambda expression and interface on demand

        SubMenu subMenu = home.clickMenu("Groups");
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
        subMenu = home.clickMenu("Groups");
        groups = subMenu.clickMyGroupsLink();
        EditGroupPopup editGroupPopup = groups.clickEditGroup(groupName);
        groupMap = new HashMap<>();
        groupMap.put("name", groupName);
        groupMap.put("description", "Descriptiond");
        groupMap.put("code", "testcode04Edit");
        groupMap.put("privacy", "No One");
        groupMap.put("access", "Allow Requests");
        groupMap.put("category", "Faculty Groups");
        groups = editGroupPopup.edit(groupMap);


        //then
        Assert.assertEquals(groupName + " has been saved.", groups.getMessage());
        Assert.assertEquals(groupMap.get("name"), groups.getGroupByName(groupName));
        //home.clickMenu("Groups");
        //subMenu.clickMyGroupsLink();
    }

}
