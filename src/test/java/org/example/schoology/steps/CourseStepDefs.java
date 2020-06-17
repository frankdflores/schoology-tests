package org.example.schoology.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.SharedDriver;
import org.example.schoology.pages.*;
import org.junit.Assert;

import java.util.Map;

public class CourseStepDefs {

    private SubMenu subMenu;

    private Courses courses;

    private Groups groups;

    private Resources resources;
    private AddQuestionPopup addQuestionPopup;

    public CourseStepDefs(SharedDriver sharedDriver){

    }

    @And("I create a course with:")
    public void iCreateACourseWith(Map<String, String> datatable) {
        subMenu = new Home().clickMenu("Courses");
        courses = subMenu.clickMyCoursesLink();
        CreateCoursePopup createCoursePopup = courses.clickCreateCourseButton();
        CoursePage coursePage = createCoursePopup.create(datatable);

    }

    @And("I edit the {string} course with:")
    public void iEditTheCourseWith(String name, Map<String, String> datatable) {
            EditCoursePopup editCoursePopup = courses.clickEditCourse(name);
            //String courseNameEdited = "EditedName";
            courses = editCoursePopup.edit(datatable);
    }

    @And("I should see the {string} section on {string} course item")
    public void iShouldSeeTheSectionOnCourseItem(String expectedSection, String courseName) {
        Assert.assertEquals(expectedSection, courses.getSectionByName(courseName));
    }
}


