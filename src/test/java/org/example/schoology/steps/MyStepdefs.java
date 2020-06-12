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
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.SubMenu;
import org.junit.Assert;

public class MyStepdefs {

	private Home home;

	private SubMenu subMenu;

	private Courses courses;

	@Given("I log in as {string} user")
	public void iLogInAsUser(String account) {
		Login login = new Login();
		home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
	}

	@And("I create a course with:")
	public void iCreateACourseWith(Map<String, String> datatable) {
		subMenu = home.clickMenu("Courses");
		courses = subMenu.clickMyCoursesLink();
		CreateCoursePopup createCoursePopup = courses.clickCreateCourseButton();
		CoursePage coursePage = createCoursePopup.create(datatable);
	}

	@When("I navigate to Courses")
	public void iNavigateToCourses() {
		subMenu = home.clickMenu("Courses");
		courses = subMenu.clickMyCoursesLink();
	}

	@And("I edit the {string} course with:")
	public void iEditTheCourseWith(String courseName, Map<String, String> datatable) {
		EditCoursePopup editCoursePopup = courses.clickEditCourse(courseName);
		courses = editCoursePopup.edit(datatable);
	}

	@Then("I should see the {string} message")
	public void iShouldSeeTheMessage(String message) {
		Assert.assertEquals(message, courses.getMessage());
	}

	@And("I should see the {string} section on {string} course item")
	public void iShouldSeeTheSectionOnCourseItem(String expectedSection, String courseName) {
		Assert.assertEquals(expectedSection, courses.getSectionByName(courseName));
	}
}
