package org.example.schoology.tests;

import org.example.schoology.pages.*;
import org.junit.Test;

public class CoursesTest {

	@Test
	public void editCourse() {
		Login login = new Login();
		Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
		SubMenu subMenu = home.clickMenu("Courses");
		Courses courses = subMenu.clickMyCoursesLink();

		CreateModal createModal = courses.openModal();
		createModal.createNewCourse("Test Modal");
		courses.endProcess();
	}

}
