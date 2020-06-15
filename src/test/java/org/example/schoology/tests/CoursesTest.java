package org.example.schoology.tests;

import org.example.schoology.pages.CoursePage;
import org.example.schoology.pages.Courses;
import org.example.schoology.pages.CreateCoursePopup;
import org.example.schoology.pages.EditCoursePopup;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.SubMenu;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CoursesTest {
	public static final String PREFIX_AT = "AT_";

	@Test
	public void editCourse() {
		//Given
		Login login = new Login();
		Home home = login.loginAs("jacky.rosales84@gmail.com", "Control123");
		SubMenu subMenu = home.clickMenu("Courses");
		Courses courses = subMenu.clickMyCoursesLink();
		CreateCoursePopup createCoursePopup = courses.clickCreateCourseBtn();
		String courseName= PREFIX_AT + "Test course" + System.currentTimeMillis();

		Map<String, String> courseMap = new HashMap<>();
		courseMap.put("name",courseName);
		courseMap.put("section", "Section");
		courseMap.put("area", "Mathematics");
		courseMap.put("level", "Undergraduate");
		CoursePage coursePage = createCoursePopup.create(courseMap);

		//When
		subMenu = home.clickMenu("Courses");
		courses = subMenu.clickMyCoursesLink();
		EditCoursePopup editCoursePopup = courses.clickEditCourse(courseName);
		courseMap = new HashMap<>();
		courseMap.put("section", "Section Test");
		courseMap.put("area" , "Science");
		courses = editCoursePopup.edit(courseMap);

		// Then
		// Soft Assert
		// Hard Assert
		Assert.assertEquals("The section has been updated.", courses.getMessage());
		Assert.assertEquals("Section Test" , courses.getSectionByName(courseName));




//		subMenu = home.clickMenu("Courses");
//		courses = subMenu.clickMyCoursesLink();
//		courses.editCourse("Test Course");

	}

}
