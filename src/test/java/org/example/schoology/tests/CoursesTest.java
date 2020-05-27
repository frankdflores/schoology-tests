package org.example.schoology.tests;

import org.example.schoology.pages.Courses;
import org.example.schoology.pages.CreateCourse;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.SubMenu;
import org.junit.Test;

public class CoursesTest {
	public CoursesTest() {
	}

	@Test
	public void editCourse() {
		Login login = new Login();
		Home home = login.loginAs("mixmeil@gmail.com", "Control123");
		SubMenu subMenu = home.clickMenu("Courses");
		Courses courses = subMenu.clickMyCoursesLink();
		CreateCourse createCourse = courses.clickCreateCourse();
		createCourse.createCourse("MT-TestCourse001", "MT-SectionTest", "Mathematics", "Undergraduate");

//		driver.findElement(By.cssSelector("a.create-course-btn")).click();
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
