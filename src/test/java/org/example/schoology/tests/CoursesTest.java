package org.example.schoology.tests;

import java.util.HashMap;
import java.util.Map;

import org.example.schoology.pages.Course;
import org.example.schoology.pages.Courses;
import org.example.schoology.pages.CreateCoursePopup;
import org.example.schoology.pages.EditCoursePopup;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.SubMenu;
import org.junit.Assert;
import org.junit.Test;

public class CoursesTest {

	public static final String PREFIX_AT = "AT_";

	@Test
	public void editCourseTest() {
		// Given
		Login login = new Login();
		Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
		String menu = "Courses";
		SubMenu subMenu = home.clickMenu(menu);
		subMenu.clickViewListLink(menu);
		Courses courses = new Courses();
		CreateCoursePopup createCoursePopup = courses.clickCreateCourseButton();
		String courseName = PREFIX_AT + "Test Course" + System.currentTimeMillis();

		Map<String, String> courseMap = new HashMap<>();
		courseMap.put("name", courseName);
		courseMap.put("section", "Section");
		courseMap.put("area", "Mathematics");
		courseMap.put("level", "Undergraduate");
		Course course = createCoursePopup.create(courseMap);

		// When
		subMenu = home.clickMenu(menu);
		subMenu.clickViewListLink(menu);
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
