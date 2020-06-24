package org.example.schoology.steps;

import java.util.Map;

import io.cucumber.java.en.And;
import org.example.SharedDriver;
import org.example.schoology.pages.Course;
import org.example.schoology.pages.Courses;
import org.example.schoology.pages.CreateCoursePopup;
import org.example.schoology.pages.EditCoursePopup;
import org.example.schoology.pages.Groups;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.SubMenu;
import org.testng.Assert;

public class CourseStepDefs {

	private SubMenu subMenu;

	private Courses courses;

	private Groups groups;

	private Home home;

	public CourseStepDefs(SharedDriver sharedDriver, Home home, Courses courses) {
		this.home = home;
		this.courses = courses;
	}

	@And("I create a course with:")
	public void iCreateACourseWith(Map<String, String> datatable) {
		String menu = "Courses";
		subMenu = home.clickMenu(menu);
		subMenu.clickViewListLink(menu);
		CreateCoursePopup createCoursePopup = this.courses.clickCreateCourseButton();
		Course course = createCoursePopup.create(datatable);
	}

	@And("I edit the {string} course with:")
	public void iEditTheCourseWith(String Name, Map<String, String> datatable) {
		EditCoursePopup editCoursePopup = courses.clickEditCourse(Name);
		courses = editCoursePopup.edit(datatable);
	}

	@And("I should see the {string} section on {string} course item")
	public void iShouldSeeTheSectionOnCourseItem(String expectedSection, String courseName) {
		Assert.assertEquals(expectedSection, courses.getSectionByName(courseName));
	}

}
