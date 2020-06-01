package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubMenu {

    private final WebDriver driver;
    @FindBy(css = "a[href='/groups']")
    private WebElement myGroupsLink;

    public SubMenu(WebDriver driver) {
        this.driver = driver;
    }

    public Courses clickMyCoursesLink() {
        driver.findElement(By.cssSelector("a[href='/courses']")).click();
        return new Courses(driver);
    }

    public Groups clickMyGroupsLink() {
        myGroupsLink.click();
        return new Groups(driver);
    }
}
