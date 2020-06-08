package org.example.schoology.tests;

import org.example.schoology.pages.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CoursesTest {

	public static final String PREFIX_AT = "AT";

	@Test
	public void editCourse() {
		Login login = new Login();
		Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
		SubMenu subMenu = home.clickMenu("Courses");
		Courses courses = subMenu.clickMyCoursesLink();
		CreateCoursePopup createCoursePopup = courses.openCourseModal();

		String courseName = PREFIX_AT + "Test Course MZ" + System.currentTimeMillis();
		Map<String, String> courseMap = new HashMap<>();
		courseMap.put("name", courseName);
		courseMap.put("section", "Section");
		courseMap.put("area", "Mathematics");
		courseMap.put("level", "Undergraduate");

		CoursePage coursePage = createCoursePopup.create(courseMap);

		subMenu = home.clickMenu("Courses");
		courses = subMenu.clickMyCoursesLink();
		courses.clickEditCourse(courseName);


	}

}
