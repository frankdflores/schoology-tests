package org.example.schoology.steps;

import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.SharedDriver;
import org.example.schoology.pages.*;
import org.junit.Assert;

public class MyStepdefs {

	private Home home;

	private SubMenu subMenu;

	private Courses courses;

	private Groups groups;

	private Resources resources;

	public MyStepdefs(SharedDriver sharedDriver) {

	}

	@Given("I log in as {string} user")
	public void iLogInAsUser(String account) {
		Login login = new Login();
		home = login.loginAs("mixmeil@gmail.com", "Control123");
	}

	@And("I create a course with:")
	public void iCreateACourseWith(Map<String, String> datatable) {
		subMenu = home.clickMenu("Courses");
		courses = subMenu.clickMyCoursesLink();
		CreateCoursePopup createCoursePopup = courses.clickCreateCourseButton();
		Course course = createCoursePopup.create(datatable);
	}

	@And("I create a group with:")
	public void iCreateAGroupWith(Map<String, String> datatable) {
		subMenu = home.clickMenu("Groups");
		groups = subMenu.clickMyGroupsLink();
		CreateGroupPopup createGroupPopup = groups.clickCreateGroupButton();
		Group group = createGroupPopup.fillInTheFieldsAndCreate(datatable);
	}

	@When("I navigate to {string}")
	public void iNavigateToCourses(String menu) {
		subMenu = home.clickMenu(menu);
		if ("Courses".equals(menu)) {
			courses = subMenu.clickMyCoursesLink();
		} else {
			groups = subMenu.clickMyGroupsLink();
		}
	}

	@And("I edit the {string} course with:")
	public void iEditTheCourseWith(String Name, Map<String, String> datatable) {
		EditCoursePopup editCoursePopup = courses.clickEditCourse(Name);
		courses = editCoursePopup.edit(datatable);
	}

	@And("I edit the {string} group with:")
	public void iEditTheGroupWith(String Name, Map<String, String> datatable) {
		EditGroupPopup editGroupPopup = groups.clickEditGroup(Name);
		editGroupPopup.fillInTheFieldsAndEdit(datatable);
	}

	@Then("I should see the {string} message")
	public void iShouldSeeTheMessage(String message) {
		Assert.assertEquals(message, courses.getMessage());
	}

	@Then("I should see {string} as a message")
	public void iShouldSeeAsAMessage(String message) {
		Assert.assertEquals(message, groups.getMessage());

	}

	@And("I should see the {string} section on {string} course item")
	public void iShouldSeeTheSectionOnCourseItem(String expectedSection, String courseName) {
		Assert.assertEquals(expectedSection, courses.getSectionByName(courseName));
	}

	@And("I should see a group with {string} as a name")
	public void iShouldSeeAGroupWithAsName(String groupName) {
		Assert.assertEquals(groupName, groups.getGroupByName(groupName));

	}
	
	@And("I create a {string} resource with:")
	public void iCreateAResourceWith(String resourceName, Map<String, String> datatable) {
		resources = home.clickResourcesMenuOption();
		AddResourcePopup addResourcePopup = resources.clickAddResource(resourceName);
		resources = addResourcePopup.AddResource(datatable);
	}

	@And("I should not see a resource with {string}")
	public void iShouldNotSeeAResourceWith(String name) {
		Assert.assertFalse(resources.resourceItemExist(name));
	}

	@When("I remove a resource with name {string}")
	public void iRemoveAResourceWithName(String name) {
		DeleteResourcePopup deleteResourcePopup = resources.clickRemoveResource(name);
		resources = deleteResourcePopup.clickDeleteButton();
	}

	@And("I wait for message disappear")
	public void iWaitForMessageDisappear() {
		resources.waitForMessageContainerDisappear();
	}

	@Then("I should see message {string}")
	public void iShouldSeeMessage(String message) {
		Assert.assertEquals(message, resources.getMessage());
	}
}
