package org.example.schoology.tests;

import org.example.schoology.pages.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GroupsTest {

    @Test
    public void editGroup() {
        Login login = new Login();
        Home home = login.loginAs("mixmeil@gmail.com", "Control123");
        SubMenu subMenu = home.clickMenu("Groups");
        Groups groups = subMenu.clickMyGroupsLink();
        CreateGroupPopup createGroupPopup = groups.clickCreateGroupButton();

        Map<String, String> groupMap = new HashMap<>();

        /*Attempt 01*/
        /*groupMap.put("name","MT - Test Group");
        groupMap.put("description", "MT - This is a Description Text, only for testing purposes");
        groupMap.put("privacy", "Custom");
        groupMap.put("access", "Allow Requests");
        groupMap.put("category", "General");*/

        /*Attempt 02*/
        /*groupMap.put("name","MT - Test Group");
        groupMap.put("description", "MT - This is a Description Text, only for testing purposes");
        groupMap.put("privacy", "No One");
        groupMap.put("access", "Open");*/

        /*Attempt 03*/
        groupMap.put("name","MT - Test Group");
        groupMap.put("description", "Nothing to see here");

        createGroupPopup.create(groupMap);







    }

}
