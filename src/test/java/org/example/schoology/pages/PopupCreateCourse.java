package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PopupCreateCourse {

    private WebDriver driver;

    public PopupCreateCourse(WebDriver driver) {
        this.driver = driver;
    }

    public Materials fillInTheFieldsAndCreate(String courseName, String sectionName, String subjectArea, String level){
        driver.findElement(By.cssSelector("#edit-course-name")).sendKeys(courseName);

        WebElement sectionField  = driver.findElement(By.cssSelector("#edit-section-name-1"));
        sectionField.clear();
        sectionField.sendKeys(sectionName);

        Select subjectAreaField = new Select(driver.findElement(By.cssSelector("#edit-subject-area")));
		subjectAreaField.selectByVisibleText(subjectArea);

		Select levelField = new Select(driver.findElement(By.cssSelector("#edit-grade-level-range-start")));
		levelField.selectByVisibleText(level);

		driver.findElement(By.cssSelector("#edit-submit")).click();
        return  new Materials(driver);
    }
}
