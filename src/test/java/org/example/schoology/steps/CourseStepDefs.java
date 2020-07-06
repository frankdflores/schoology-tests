package org.example.schoology.steps;

import io.cucumber.java.en.And;
import org.example.core.Internationalization;
import org.example.core.ScenarioContext;
import org.example.core.ui.SharedDriver;
import org.example.schoology.pages.*;
import org.example.schoology.pages.courses.Courses;
import org.example.schoology.pages.courses.CreateCoursePopup;
import org.example.schoology.pages.courses.EditCoursePopup;
import org.junit.Assert;

import java.util.Map;

public class CourseStepDefs {

    private ScenarioContext context;

    private Home home;

    private SubMenu subMenu;

    private Courses courses;

    public CourseStepDefs(SharedDriver sharedDriver, final ScenarioContext context, Home home, Courses courses){
        this.context = context;
        this.home = home;
        this.courses = courses;
    }

    @And("I create a course with:")
    public void iCreateACourseWith(Map<String, String> datatable) {
        String menu = Internationalization.getInstance().getValue("menu");
        subMenu = home.clickMenu(menu);
        subMenu.clickViewListLink(menu);
        CreateCoursePopup createCoursePopup = this.courses.clickCreateCourseButton();
        createCoursePopup.create(datatable);
        context.setContext("CourseKey", datatable.get("name"));
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


