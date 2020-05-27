package org.example.schoology.tests;

import org.example.schoology.pages.Courses;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.Materials;
import org.example.schoology.pages.PopupCreateCourse;
import org.example.schoology.pages.SubMenu;
import org.junit.Test;

public class CoursesTest {

	@Test
	public void editCourse() {
		Login login = new Login();
		Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
		SubMenu subMenu = home.clickMenu("Courses");
		Courses courses = subMenu.clickMyCoursesLink();
		PopupCreateCourse popupCreateCourse = courses.clickCreateCourseButton();
		Materials materials = popupCreateCourse.fillInTheFieldsAndCreate("Test Course",
				"Section", "Mathematics", "Undergraduate");
		home.clickMenu("Courses");
		subMenu.clickMyCoursesLink();
		courses.clickActionCourse("Test Course");
	}

}
