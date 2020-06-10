package org.example.schoology.tests;

import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.courses.CoursePage;
import org.example.schoology.pages.courses.Courses;
import org.example.schoology.pages.courses.CoursesSubMenu;
import org.example.schoology.pages.courses.CreateCoursePopup;
import org.example.schoology.pages.courses.EditCoursePopup;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CoursesTest {

	public static final String PREFIX_AT = "AT_";

	@Test
	public void editCourseTest() {

		// Given
		Login login = new Login();
		Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
		CoursesSubMenu coursesSubMenu = home.clickCoursesMenu();
		Courses courses = coursesSubMenu.clickMyCoursesLink();
		CreateCoursePopup createCoursePopup = courses.clickCreateCourseButton();


		// Test Data
		String courseName = PREFIX_AT + "Test Course" + System.currentTimeMillis();
		Map<String, String> courseMap = new HashMap<>();
		courseMap.put("name", courseName);
		courseMap.put("section", "Section");
		courseMap.put("area", "Mathematics");
		courseMap.put("level", "Undergraduate");
		CoursePage coursePage = createCoursePopup.create(courseMap);

		// When
		coursesSubMenu = home.clickCoursesMenu();
		courses = coursesSubMenu.clickMyCoursesLink();
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
}
