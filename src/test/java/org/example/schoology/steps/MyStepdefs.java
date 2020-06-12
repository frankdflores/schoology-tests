package org.example.schoology.steps;

import java.util.HashMap;
import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.schoology.pages.CoursePage;
import org.example.schoology.pages.Courses;
import org.example.schoology.pages.CreateCoursePopup;
import org.example.schoology.pages.EditCoursePopup;
import org.example.schoology.pages.Group;
import org.example.schoology.pages.Groups;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.PopupCreateGroup;
import org.example.schoology.pages.PopupEditGroup;
import org.example.schoology.pages.SubMenu;
import org.junit.Assert;

public class MyStepdefs {

	private Home home;

	private SubMenu subMenu;

	private Courses courses;

	private Groups groups;

	@Given("I log in as {string} user")
	public void iLogInAsUser(String account) {
		Login login = new Login();
		home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
	}

	@And("I create a {string} with:")
	public void iCreateACourseWith(String courses_groups,Map<String, String> datatable) {
		if (courses_groups.equals("Course")) {
			subMenu = home.clickMenu("Courses");
			courses = subMenu.clickMyCoursesLink();
			CreateCoursePopup createCoursePopup = courses.clickCreateCourseButton();
			CoursePage coursePage = createCoursePopup.create(datatable);
		} else {
			subMenu = home.clickMenu("Groups");
			groups = subMenu.clickMyGroupsLink();
			PopupCreateGroup popupCreateGroup = groups.clickCreateGroupButton();
			Group group = popupCreateGroup.fillInTheFieldsAndCreate(datatable);
		}

	}

	@When("I navigate to {string}")
	public void iNavigateToCourses(String courses_groups) {
		subMenu = home.clickMenu(courses_groups);
		if (courses_groups.equals("Courses")) {
			courses = subMenu.clickMyCoursesLink();
		} else {
			groups = subMenu.clickMyGroupsLink();
		}


	}

	@And("I edit the {string} {string} with:")
	public void iEditTheCourseWith(String Name, String courses_groups, Map<String, String> datatable) {
		if (courses_groups.equals("course")) {
			EditCoursePopup editCoursePopup = courses.clickEditCourse(Name);
			courses = editCoursePopup.edit(datatable);
		}else {
			PopupEditGroup popupEditGroup = groups.clickEditGroup(Name);
			popupEditGroup.fillInTheFieldsAndEdit(datatable);
		}

	}

	@Then("I should see the {string} message")
	public void iShouldSeeTheMessage(String message) {
		Assert.assertEquals(message, courses.getMessage());
	}

	@And("I should see the {string} section on {string} course item")
	public void iShouldSeeTheSectionOnCourseItem(String expectedSection, String courseName) {
		Assert.assertEquals(expectedSection, courses.getSectionByName(courseName));
	}

	@And("I should see a group with {string} as a name")
	public void iShouldSeeAGroupWithAsName(String groupName) {
		Assert.assertEquals(groupName, groups.getGroupByName(groupName));

	}

	@Then("I should see {string} as a message")
	public void iShouldSeeAsAMessage(String message) {
		Assert.assertEquals(message, groups.getMessage());

	}
}
