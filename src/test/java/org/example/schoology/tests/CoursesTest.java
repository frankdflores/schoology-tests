package org.example.schoology.tests;

import org.example.schoology.pages.Courses;
import org.example.schoology.pages.CreateCoursePopup;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.SubMenu;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CoursesTest {

	@Test
	public void editCourse() {
		Login login = new Login();
		Home home = login.loginAs("jacky.rosales84@gmail.com", "Control123");
		SubMenu subMenu = home.clickMenu("Courses");
		Courses courses = subMenu.clickMyCoursesLink();
		CreateCoursePopup createCoursePopup = courses.clickCreateCourseBtn();
		//Course course = new Course();
		String courseName= "Test course";

		Map<String, String> courseMap = new HashMap<>();
		courseMap.put("name",courseName);
		courseMap.put("section", "Section");
		courseMap.put("area", "Mathematics");
		courseMap.put("level", "Undergraduate");
		createCoursePopup.create(courseMap);


//		subMenu = home.clickMenu("Courses");
//		courses = subMenu.clickMyCoursesLink();
//		courses.editCourse("Test Course");

	}

}
