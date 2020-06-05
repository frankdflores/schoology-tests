package org.example.schoology.tests;

import org.example.schoology.pages.courses.Courses;
import java.util.HashMap;
import java.util.Map;

import org.example.schoology.pages.CoursePage;
import org.example.schoology.pages.Courses;
import org.example.schoology.pages.CreateCoursePopup;
import org.example.schoology.pages.EditCoursePopup;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class CoursesTest {

	public static final String PREFIX_AT = "AT_";

	@Test
	public void editCourseTest() {
		// Given
		Login login = new Login();
		Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
		SubMenu subMenu = home.clickMenu("Courses");
		Courses courses = subMenu.clickMyCoursesLink();
		CreateCoursePopup createCoursePopup = courses.clickCreateCourseButton();
		String courseName = PREFIX_AT + "Test Course" + System.currentTimeMillis();

		// Test Data
		String courseName = "Test Course";
		Map<String, String> courseMap = new HashMap<>();
		courseMap.put("name", courseName);
		courseMap.put("section", "Section");
		courseMap.put("area", "Mathematics");
		courseMap.put("level", "Undergraduate");
		CoursePage coursePage = createCoursePopup.create(courseMap);
		login = new Login();
		Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
		CoursesSubMenu coursesSubMenu = home.clickCoursesMenu();
		Courses courses = coursesSubMenu.clickMyCoursesLink();
		CreateCoursePopup createCoursePopup = courses.clickCreateCourseButton();

		// When
		subMenu = home.clickMenu("Courses");
		courses = subMenu.clickMyCoursesLink();
		EditCoursePopup editCoursePopup = courses.clickEditCourse(courseName);
		courseMap = new HashMap<>();
		courseMap.put("section", "Section Test");
		courseMap.put("area", "Science");
		courses = editCoursePopup.edit(courseMap);

		// Then
		// Soft Assert
		// Hard Assert
		Assert.assertEquals("The section has been updated.",
				courses.getMessage());
		Assert.assertEquals("Section Test",
				courses.getSectionByName(courseName));
	}

	// ToDo: This after method is temporal, remove it when a driver manager is implemented
	@After
	public void quitDriver() {
		login.quit();
	}
}
