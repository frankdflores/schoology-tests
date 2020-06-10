package org.example.schoology.pages.courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoursesSubMenu {

    private WebDriver driver;

    @FindBy(css = "a[href='/courses']")
    private WebElement myCoursesLink;

    public CoursesSubMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Courses clickMyCoursesLink() {
        myCoursesLink.click();
        return new Courses(driver);
    }
}
