package org.example.schoology.tests;

import org.example.SharedDriver;
import org.example.schoology.pages.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CoursesTest {

	public static final String PREFIX_AT = "AT_";

	@Test
	public void editCourseTest() {
		//new SharedDriver();
		// Given
		Login login = new Login();
		Home home = login.loginAs("magnethus01@gmail.com", "TheTop86!");
		String menu = "Courses";
		SubMenu subMenu = home.clickMenu(menu);
		subMenu.clickViewListLink(menu);
		Courses courses = new Courses();
		CreateCoursePopup createCoursePopup = courses.clickCreateCourseButton();
		//Course course = new Course();
		String courseName = PREFIX_AT + "Test Course009" + System.currentTimeMillis();

		Map<String, String> courseMap = new HashMap<>();
		courseMap.put("name", courseName);
		courseMap.put("section", "Section009");
		courseMap.put("area", "Mathematics");
		courseMap.put("level", "Undergraduate");
		CoursePage coursePage = createCoursePopup.create(courseMap);


		//When
		subMenu = home.clickMenu(menu);
		subMenu.clickViewListLink(menu);
		EditCoursePopup editCoursePopup = courses.clickEditCourse(courseName);
		String courseNameEdited = "EditedName";

		courseMap = new HashMap<>();
		courseMap.put("name", courseName);
		courseMap.put("section", "Section010edited");
		courseMap.put("area", "Mathematics");
		courseMap.put("level", "Undergraduate");
		courses = editCoursePopup.edit(courseMap);

		//then
		Assert.assertEquals("The section has been updated.", courses.getMessage());

		Assert.assertEquals("Section010edited", courses.getSectionByName(courseName));


		//home.clickMenu("Courses");
		//subMenu.clickMyCoursesLink();



	}

}
