package org.example.schoology.tests;

import org.example.schoology.pages.courses.Courses;
import java.util.HashMap;
import java.util.Map;

import org.example.schoology.pages.courses.CoursesSubMenu;
import org.example.schoology.pages.courses.CreateCoursePopup;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.junit.After;
import org.junit.Test;

public class CoursesTest {

	Login login;

	@Test
	public void editCourse() {

		// Test Data
		String courseName = "Test Course";
		Map<String, String> courseMap = new HashMap<>();
		courseMap.put("name", courseName);
		courseMap.put("section", "Section");
		courseMap.put("area", "Mathematics");
		courseMap.put("level", "Undergraduate");

		login = new Login();
		Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
		CoursesSubMenu coursesSubMenu = home.clickCoursesMenu();
		Courses courses = coursesSubMenu.clickMyCoursesLink();
		CreateCoursePopup createCoursePopup = courses.clickCreateCourseButton();
		createCoursePopup.create(courseMap);

		// Edit Course
		coursesSubMenu = home.clickCoursesMenu();
		courses = coursesSubMenu.clickMyCoursesLink();
		courses.expandActionsMenuForCourse(courseName);


//		String courseName = "Test Course";
//		driver.findElement(By.cssSelector("#edit-course-name")).sendKeys(courseName);
//		WebElement sectionField = driver.findElement(By.cssSelector("#edit-section-name-1"));
//		sectionField.clear();
//		sectionField.sendKeys("Section");
//		Select subjectArea = new Select(driver.findElement(By.cssSelector("#edit-subject-area")));
//		subjectArea.selectByVisibleText("Mathematics");
//		Select level = new Select(driver.findElement(By.cssSelector("#edit-grade-level-range-start")));
//		level.selectByVisibleText("Undergraduate");
//
//		driver.findElement(By.cssSelector("#edit-submit")).click();
//
//		driver.findElement(By.xpath("//span[text()='Courses']/parent::button")).click();
//
//		driver.findElement(By.cssSelector("a[href='/courses']")).click();
//
//		String courseActions = "//span[text()='%s']/ancestor::li//div[@class='action-links-unfold ']";
//		driver.findElement(By.xpath(String.format(courseActions, courseName))).click();
	}

	// ToDo: This after method is temporal, remove it when a driver manager is implemented
	@After
	public void quitDriver() {
		login.quit();
	}
}
