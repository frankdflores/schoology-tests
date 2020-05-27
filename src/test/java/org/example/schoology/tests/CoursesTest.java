package org.example.schoology.tests;

import org.example.schoology.pages.*;
import org.junit.Test;

public class CoursesTest {

    @Test
    public void editCourse() {
        Login login = new Login();
        Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
        home.cancelVerificationAccount();
        SubMenu subMenu = home.clickMenu("Courses");
        Courses courses = subMenu.clickMyCoursesLink();

        // create course
        String courseName = "FirstCourse";
        Materials materials = courses.createCourse(courseName, "sectionedit", "Other", "Graduate");
        subMenu = home.clickMenu("Courses");
        courses = subMenu.clickMyCoursesLink();
        courses.courseActions(courseName);
        courses.endProcess();
    }

}
