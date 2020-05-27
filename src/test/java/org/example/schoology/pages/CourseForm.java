package org.example.schoology.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CourseForm {

    private WebDriver driver;

    @FindBy(css = "#edit-course-name")
    private WebElement course_name;

    @FindBy(css = "#edit-section-name-1")
    private WebElement sectionField;

    //@FindBy(css = "select#edit-subject-area")
    //private Select subjectArea;

    //@FindBy(css = "select#edit-grade-level-range-start")
    //private Select level;

    @FindBy(css = "#edit-submit")
    private WebElement submit_button;

    public CourseForm(WebDriver driver) {

        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);

    }

    public Home fillOutCurseForm(String courseName, String section_name, String Subject_area, String level_mname){
        course_name.sendKeys(courseName);
        sectionField.clear();
        sectionField.sendKeys(section_name);
        //subjectArea.selectByVisibleText("Mathematics");
        //level.selectByVisibleText("Undergraduate");
        Set_Section_Area(Subject_area, level_mname);

//		String courseName = "Test Course";
//		driver.findElement(By.cssSelector("#edit-course-name")).sendKeys(courseName);
//		WebElement sectionField = driver.findElement(By.cssSelector("#edit-section-name-1"));
//		sectionField.clear();
//		sectionField.sendKeys("Section");
////		driver.findElement(By.cssSelector("#edit-submit")).click();
        submit_button.click();
        return new Home(driver);
    }
     private void Set_Section_Area(String Subject_area, String level_mname){
        Select subjectArea = new Select(driver.findElement(By.cssSelector("#edit-subject-area")));
		subjectArea.selectByVisibleText(Subject_area);
		Select level = new Select(driver.findElement(By.cssSelector("#edit-grade-level-range-start")));
		level.selectByVisibleText(level_mname);

     }
}

