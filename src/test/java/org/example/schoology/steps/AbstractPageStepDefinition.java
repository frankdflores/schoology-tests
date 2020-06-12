package org.example.schoology.steps;

import org.example.schoology.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPageStepDefinition {

    protected static Login login;
    protected static Home home;
    protected static Courses courses;
    protected static SubMenu submenu;
    protected static CreateCoursePopup createCoursePopup;
    protected static CoursePage coursePage;
    protected static EditCoursePopup editCoursePopup;

    private static WebDriver driver;

    protected Login getLogin(){
        if (login == null){
            login = new Login();
        }
        return login;
    }


    protected Home getHome(){
        if (home == null){
            home = new Home(driver);
        }
        return home;
    }

    protected Courses getCourses(){
        if (courses == null){
            courses = new Courses(driver);
        }
        return courses;
    }

    protected SubMenu getSubmenu(){
        if (submenu == null){
            submenu = new SubMenu(driver);
        }
        return submenu;
    }

    protected CreateCoursePopup getCreateCoursePopup(){
        if (createCoursePopup == null){
            createCoursePopup = new CreateCoursePopup(driver);
        }
        return createCoursePopup;
    }

    protected CoursePage getCoursePage(){
        if (coursePage == null){
            coursePage = new CoursePage(driver);
        }
        return coursePage;
    }

    protected EditCoursePopup getEditCoursePopup(){
        if (editCoursePopup == null){
            editCoursePopup = new EditCoursePopup(driver);
        }
        return editCoursePopup;
    }

}
