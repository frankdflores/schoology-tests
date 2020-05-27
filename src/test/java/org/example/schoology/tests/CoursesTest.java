package org.example.schoology.tests;

import org.example.schoology.pages.courses.Courses;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.courses.CreateCourseModal;
import org.junit.After;
import org.junit.Test;

public class CoursesTest {

	Login login;

	@Test
	public void editCourse() {

		// Test Data
		String courseName = "Test Course";
		String section = "Section";
		String subjectArea = "Mathematics";
		String level = "Undergraduate";

		login = new Login();
		Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
		SubMenu subMenu = home.clickMenu("Courses");
		Courses courses = subMenu.clickMyCoursesLink();
		CreateCourseModal createCourseModal =  courses.clickCreateCourseButton();
		createCourseModal.createCourse(courseName, section, subjectArea, level);
		subMenu = home.clickMenu("Courses");
		courses = subMenu.clickMyCoursesLink();
		courses.expandActionsMenuForCourse(courseName);
	}

	// ToDo: This after method is temporal, remove it when a driver manager is implemented
	@After
	public void quitDriver() {
		login.quit();
	}

}
