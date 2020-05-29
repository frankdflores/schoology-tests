package org.example.schoology.tests;

import org.example.schoology.pages.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CoursesTest {

	@Test
	public void editCourse() {
		Login login = new Login();
		Home home = login.loginAs("LYNX_LEXX@hotmail.com", "TheTop86!");
		SubMenu subMenu = home.clickMenu("Courses");
		Courses courses = subMenu.clickMyCoursesLink();
		CreateCoursePopup createCoursePopup = courses.clickCreateCourseButton();
		//Course course = new Course();
		String courseName = "Test Course01";
		Map<String, String> courseMap = new HashMap<>();
		courseMap.put("name", courseName);
		courseMap.put("section", "Section07");
		courseMap.put("area", "Mathematics");
		courseMap.put("level", "Undergraduate");
		createCoursePopup.create(courseMap);

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
