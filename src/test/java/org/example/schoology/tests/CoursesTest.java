package org.example.schoology.tests;

import java.util.HashMap;
import java.util.Map;

import org.example.schoology.entities.Course;
import org.example.schoology.pages.Courses;
import org.example.schoology.pages.CreateCoursePopup;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.SubMenu;
import org.junit.Test;

public class CoursesTest {

	@Test
	public void editCourse() {
		Login login = new Login();
		Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
		SubMenu subMenu = home.clickMenu("Courses");
		Courses courses = subMenu.clickMyCoursesLink();
		CreateCoursePopup createCoursePopup = courses.clickCreateCourseButton();
		//Course course = new Course();
		String courseName = "Test Course";

		Map<String, String> courseMap = new HashMap<>();
		courseMap.put("name", courseName);
		courseMap.put("section", "Section");
		courseMap.put("area", "Mathematics");
		courseMap.put("level", "Undergraduate");
		createCoursePopup.create(courseMap);

//
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

}
