package org.example.schoology.tests;

import org.example.schoology.pages.*;
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
		Group group = createGroupPopup.create(groupMap);


        //When
        subMenu = home.clickMenu("Groups");
        groups = subMenu.clickMyGroupsLink();
        groups.clickEditGroup(groupName);
        EditGroupPopup editGroupPopup = groups.clickActionEditGroup(groupName);
        String editGroupName = "Edited";
        Map<String, String> editGroupMap = new HashMap<>();
        editGroupMap.put("newname", editGroupName);
        editGroupMap.put("newdescription", "Description08edit");
        editGroupMap.put("newgroupcode", "testcode01");
        editGroupMap.put("newprivacy", "No One");
        editGroupMap.put("newaccess", "Allow Requests");
        editGroupMap.put("newcategory", "Faculty Groups");
        Groups groupEdited = editGroupPopup.edit(editGroupMap);


        //home.clickMenu("Groups");
        //subMenu.clickMyGroupsLink();
    }

}
