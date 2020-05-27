package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Courses {

	private WebDriver driver;
	private String name, section,area,level;

	public Courses(WebDriver driver) {
		this.driver = driver;
	}

	public Courses(String name, String section, String area, String level) {
		this.name = name;
		this.section = section;
		this.area = area;
		this.level = level;
	}

	public void setName (String name) {
		this.name = name;
		driver.findElement(By.cssSelector("#edit-course-name")).sendKeys(name);
	}

	public void setSection (String section) {
		this.name = section;
		WebElement sectionField = driver.findElement(By.cssSelector("#edit-section-name-1"));
		sectionField.clear();
		sectionField.sendKeys(section);
	}

	public void setArea (String area) {
		this.name = area;
		Select subjectArea = new Select(driver.findElement(By.cssSelector("#edit-subject-area")));
		subjectArea.selectByVisibleText(area);
	}

	public void setLevel (String nlevel) {
		this.name = level;
		Select level = new Select(driver.findElement(By.cssSelector("#edit-grade-level-range-start")));
		level.selectByVisibleText(nlevel);
	}

	public void clickCreateCourseBtn() {
		driver.findElement(By.cssSelector("a.create-course-btn")).click();
	}

	public void fillFormNewCourse(String name, String section, String area, String nlevel) {
		setName(name);
		setSection(section);
		setArea(area);
		setLevel(nlevel);
	}
	public void submitCourse(){
		driver.findElement(By.cssSelector("#edit-submit")).click();
	}

	public void editCourse(String courseName) {
		String courseActions = "//span[text()='%s']/ancestor::li//div[@class='action-links-unfold ']";
		driver.findElement(By.xpath(String.format(courseActions, courseName))).click();
	}
}
