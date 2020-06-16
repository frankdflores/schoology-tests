package org.example.schoology.steps;

import java.util.Map;

import io.cucumber.java.en.And;
import org.example.SharedDriver;
import org.example.schoology.pages.Courses;
import org.example.schoology.pages.CreateGroupPopup;
import org.example.schoology.pages.EditGroupPopup;
import org.example.schoology.pages.Group;
import org.example.schoology.pages.Groups;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.SubMenu;
import org.junit.Assert;

public class GroupStepDefs {

	private SubMenu subMenu;

	private Courses courses;

	private Groups groups;

	public GroupStepDefs(SharedDriver sharedDriver, Groups groups) {
		this.groups = groups;
	}

	@And("I create a group with:")
	public void iCreateAGroupWith(Map<String, String> datatable) {
		String menu = "Groups";
		subMenu = new Home().clickMenu(menu);
		subMenu.clickViewListLink(menu);
		CreateGroupPopup createGroupPopup = this.groups.clickCreateGroupButton();
		Group group = createGroupPopup.fillInTheFieldsAndCreate(datatable);
	}

	@And("I edit the {string} group with:")
	public void iEditTheGroupWith(String Name, Map<String, String> datatable) {
		EditGroupPopup editGroupPopup = groups.clickEditGroup(Name);
		editGroupPopup.fillInTheFieldsAndEdit(datatable);
	}

	@And("I should see a group with {string} as a name")
	public void iShouldSeeAGroupWithAsName(String groupName) {
		Assert.assertEquals(groupName, groups.getGroupByName(groupName));
	}

}
