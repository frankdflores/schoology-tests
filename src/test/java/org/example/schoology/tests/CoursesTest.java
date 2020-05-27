package org.example.schoology.tests;

import org.example.schoology.pages.Courses;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.SubMenu;
import org.junit.Test;

public class CoursesTest {

	@Test
	public void editCourse() {
		Login login = new Login();
		Home home = login.loginAs("jacky.rosales84@gmail.com", "Control123");
		SubMenu subMenu = home.clickMenu("Courses");
		Courses courses = subMenu.clickMyCoursesLink();

		courses.clickCreateCourseBtn();
		courses.fillFormNewCourse("Test Course", "section A", "Mathematics", "Undergraduate");
		courses.submitCourse();

		subMenu = home.clickMenu("Courses");
		courses = subMenu.clickMyCoursesLink();
		courses.editCourse("Test Course");

	}

}
