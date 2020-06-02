package org.example.schoology.tests;

import org.example.schoology.pages.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CoursesTest {

	public static final String PREFIX_AT = "AT_";

	@Test
	public void editCourseTest() {
		// Given
		Login login = new Login();
		Home home = login.loginAs("LYNX_LEXX@hotmail.com", "TheTop86!");
		SubMenu subMenu = home.clickMenu("Courses");
		Courses courses = subMenu.clickMyCoursesLink();
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
		subMenu = home.clickMenu("Courses");
		courses = subMenu.clickMyCoursesLink();
		courses.clickEditCourse(courseName);



		//home.clickMenu("Courses");
		//subMenu.clickMyCoursesLink();



	}

}
