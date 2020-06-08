package org.example.schoology.tests;

import org.example.schoology.pages.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GroupTest {
    @Test
    public void createGroup() {
        Login login = new Login();
        Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
        SubMenu subMenu = home.clickMenu("Groups");
        Groups groups = subMenu.clickMyGroupsLink();
        CreateGroupPopup createGroupPopup = groups.openGroupsModal();

        String groupName = "Test Group MZ";
        Map<String, String> courseMap = new HashMap<>();
        courseMap.put("name", groupName);
        courseMap.put("description", "test description");
        courseMap.put("privacyLevel", "School");
        courseMap.put("accessType", "Open");
//        courseMap.put("category", "Undergraduate");

        createGroupPopup.create(courseMap);
        
    }
}
