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
		CreateGroupPopup createGroupPopup = groups.clickCreateGroupButton();
		String groupName = "Test Group";

		Map<String, String> groupMap = new HashMap<>();
		groupMap.put("name", groupName);
		groupMap.put("description", "Test Description");
		groupMap.put("privacy", "No One");
		groupMap.put("access", "Open");
		groupMap.put("category", "General");
		createGroupPopup.create(groupMap);
	}
}
