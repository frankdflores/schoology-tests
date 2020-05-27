package org.example.schoology.tests;

import org.example.schoology.pages.*;
import org.junit.Test;

public class CoursesTest {

	@Test
	public void editCourse() {
		Login login = new Login();
		Home home = login.loginAs("LYNX_LEXX@hotmail.com", "TheTop86!");
		SubMenu subMenu = home.clickMenu("Courses");
		Courses courses = subMenu.clickMyCoursesLink();
		CreateCourseModal course1 = courses.clickCreateCourse();
		course1.createCourse("Course one", "Section one", "Mathematics", "Undergraduate" );
		home.clickMenu("Courses");
		subMenu.clickMyCoursesLink();

//		driver.findElement(By.xpath("//span[text()='Courses']/parent::button")).click();
//
//		driver.findElement(By.cssSelector("a[href='/courses']")).click();
//
//		String courseActions = "//span[text()='%s']/ancestor::li//div[@class='action-links-unfold ']";
//		driver.findElement(By.xpath(String.format(courseActions, courseName))).click();
	}

}
