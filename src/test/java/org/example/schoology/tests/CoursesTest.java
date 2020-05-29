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
		String courseName = "Test Course008";
		Map<String, String> courseMap = new HashMap<>();
		courseMap.put("name", courseName);
		courseMap.put("section", "Section008");
		courseMap.put("area", "Mathematics");
		courseMap.put("level", "Undergraduate");
		createCoursePopup.create(courseMap);

		home.clickMenu("Courses");
		subMenu.clickMyCoursesLink();

	    //Create Groups with lambda expression and interface on demand

        SubMenu subMenuGroup = home.clickMenu("Groups");
        Groups groups = subMenuGroup.clickMyGroupsLink();
        CreateGroupPopup createGroupPopup = groups.clickCreateGroupButton();
		String groupName = "Test Group004";
		Map<String, String> groupMap = new HashMap<>();
		groupMap.put("name", groupName);
		groupMap.put("description", "Description04");
		groupMap.put("privacy", "Custom");
		groupMap.put("access", "Allow Requests");
		groupMap.put("category", "Musical Groups");
		createGroupPopup.create(groupMap);

		home.clickMenu("Groups");
		subMenu.clickMyGroupsLink();

//		driver.findElement(By.xpath("//span[text()='Courses']/parent::button")).click();
//
//		driver.findElement(By.cssSelector("a[href='/courses']")).click();
//
//		String courseActions = "//span[text()='%s']/ancestor::li//div[@class='action-links-unfold ']";
//		driver.findElement(By.xpath(String.format(courseActions, courseName))).click();
	}

}
