package org.example.schoology.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.schoology.pages.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class CourseStepDefinition extends AbstractPageStepDefinition{

    private Home home = getHome();
    private Courses courses = getCourses();
    private SubMenu subMenu = getSubmenu();
    private CreateCoursePopup createCoursePopup = getCreateCoursePopup();
    private CoursePage coursePage = getCoursePage();
    private EditCoursePopup editCoursePopup = getEditCoursePopup();

    @And("I create a course with:")
    public void iCreateACourseWith(Map<String, String> datatable) {
        subMenu = home.clickMenu("Courses");
        courses = subMenu.clickMyCoursesLink();
        createCoursePopup = courses.clickCreateCourseButton();
        //Course course = new Course();
        coursePage = createCoursePopup.create(datatable);
    }

    @When("I navigate to Courses")
    public void iNavigateToCourses() {
        subMenu = home.clickMenu("Courses");
        courses = subMenu.clickMyCoursesLink();
    }

    @And("I edit the {string} course with:")
    public void iEditTheCourseWith(String courseName, Map<String, String> datatable) {
        editCoursePopup = courses.clickEditCourse(courseName);
        String courseNameEdited = "EditedName";
        courses = editCoursePopup.edit(datatable);
    }

    @And("I should see the {string} section on {string} course item")
    public void iShouldSeeTheSectionOnCourseItem(String expectedSection, String courseName) {
        Assert.assertEquals(expectedSection, courses.getSectionByName(courseName));
    }
}

