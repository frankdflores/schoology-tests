package org.example.schoology.tests;

import org.example.schoology.pages.Group;
import org.example.schoology.pages.Groups;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.PopupCreateGroup;
import org.example.schoology.pages.PopupEditGroup;
import org.example.schoology.pages.SubMenu;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GroupsTest {

    public static final String PREFIX_AT = "AT_";

    @Test
    public void editGroup() {
        Login login = new Login();
        Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
        SubMenu subMenu = home.clickMenu("Groups");
        Groups groups = subMenu.clickMyGroupsLink();
        PopupCreateGroup popupCreateGroup = groups.clickCreateGroupButton();
        String groupName = PREFIX_AT + "Test Group" + System.currentTimeMillis();

        Map<String, String> groupMap = new HashMap<>();
        groupMap.put("name", groupName);
        groupMap.put("description", "Description");
        groupMap.put("privacy", "School");
        groupMap.put("access", "Invite Only");
        groupMap.put("category", "Musical Groups");
        Group group = popupCreateGroup.fillInTheFieldsAndCreate(groupMap);

        subMenu = home.clickMenu("Groups");
        groups = subMenu.clickMyGroupsLink();
        PopupEditGroup popupEditGroup = groups.clickEditGroup(groupName);

        String NewgroupName = PREFIX_AT + "Test Group" + System.currentTimeMillis();
        Map<String, String> editGroupMap = new HashMap<>();
        editGroupMap.put("name", NewgroupName);
        groups = popupEditGroup.fillInTheFieldsAndEdit(editGroupMap);

        Assert.assertEquals(String.format("%s has been saved.", editGroupMap.get("name")), groups.getMessage());
        Assert.assertEquals(editGroupMap.get("name"), groups.getGroupByName(editGroupMap.get("name")));
    }
}
