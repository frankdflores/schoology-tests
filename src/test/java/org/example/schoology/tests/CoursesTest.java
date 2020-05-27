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
		PopupCreateCourse popupCreateCourse = courses.clickCreateCourse();
		Materials materials = popupCreateCourse.fillInTheFieldsAndCreate("Test Course",
				"Section", "Mathematics", "Undergraduate");
		home.clickMenu("Courses");
		subMenu.clickMyCoursesLink();


//		String courseActions = "//span[text()='%s']/ancestor::li//div[@class='action-links-unfold ']";
//		driver.findElement(By.xpath(String.format(courseActions, courseName))).click();
	}

}
