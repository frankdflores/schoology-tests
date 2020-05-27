package org.example.schoology.tests;
import org.example.schoology.pages.CourseForm;
import org.example.schoology.pages.Courses;
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
		CourseForm createCurse = courses.createCourseAction();
		home = createCurse.fillOutCurseForm("Test Course", "Section test", "Mathematics", "Undergraduate");
		subMenu = home.clickMenu("Courses");
		courses = subMenu.clickMyCoursesLink();
		createCurse = courses.editCourseAction("Test Course");

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
