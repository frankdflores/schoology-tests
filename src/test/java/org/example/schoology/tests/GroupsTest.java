package org.example.schoology.tests;

import org.example.schoology.pages.Courses;
import org.example.schoology.pages.CreateCoursePopup;
import org.example.schoology.pages.CreateGroupPopup;
import org.example.schoology.pages.EditGroupPopup;
import org.example.schoology.pages.GroupPage;
import org.example.schoology.pages.Groups;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.SubMenu;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GroupsTest {

    public static final String PREFIX_AT = "AT_";

    @Test
    public void editGroup() {
        //Given
        Login login = new Login();
        Home home = login.loginAs("jacky.rosales84@gmail.com", "Control123");
        SubMenu subMenu = home.clickMenu("Groups");
        Groups groups = subMenu.clickMyGroupsLink();
        CreateGroupPopup createGroupPopup = groups.clickCreateGroupBtn();
        String groupName = PREFIX_AT + "Test Group" + System.currentTimeMillis();

        Map<String, String> groupMap = new HashMap<>();
        groupMap.put("name", groupName);
        groupMap.put("description", "test group description");
        groupMap.put("privacy", "School");
        groupMap.put("access", "Invite Only");
        groupMap.put("category", "General");

        GroupPage groupPage = createGroupPopup.create(groupMap);

        //When
        subMenu = home.clickMenu("Groups");
        groups = subMenu.clickMyGroupsLink();
        EditGroupPopup editGroupPopup = groups.clickEditGroup(groupName);
        groupMap = new HashMap<>();
        groupMap.put("name", groupName);
        groupMap.put("description", "Description Modified");
        groupMap.put("category", "Musical Groups");
        groups = editGroupPopup.edit(groupMap);

        //Then
        Assert.assertEquals(groupName + " has been saved.", groups.getMessage());



    }
}