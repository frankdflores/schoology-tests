package org.example.schoology.tests;

import org.example.schoology.pages.Courses;
import org.example.schoology.pages.Group;
import org.example.schoology.pages.Groups;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.Materials;
import org.example.schoology.pages.PopupCreateCourse;
import org.example.schoology.pages.PopupCreateGroup;
import org.example.schoology.pages.PopupVerification;
import org.example.schoology.pages.SubMenu;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CoursesTest {

	@Test
	public void editCourse() {
		Login login = new Login();
		PopupVerification popupVerification = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
		Home home = popupVerification.close();

		// Create course
		SubMenu subMenu = home.clickMenu("Courses");
		Courses courses = subMenu.clickMyCoursesLink();
		PopupCreateCourse popupCreateCourse = courses.clickCreateCourseButton();

		// although it is ok it should not be implemented like this; see create groups
		Materials materials = popupCreateCourse.fillInTheFieldsAndCreate("Test Course",
				"Section", "Mathematics", "Undergraduate");

		// Create groups
		home.clickMenu("Groups");
        Groups groups = subMenu.clickMyGroupsLink();
        PopupCreateGroup popupCreateGroup = groups.clickCreateGroupButton();
        Map<String, String> groupMap = new HashMap<>();
        groupMap.put("name", "Group-1");
//        groupMap.put("description", "Description");
        groupMap.put("privacy", "School");
        groupMap.put("access", "Invite Only");
        groupMap.put("category", "Musical Groups");
        Group group = popupCreateGroup.fillInTheFieldsAndCreate(groupMap);

		home.clickMenu("Courses");
		subMenu.clickMyCoursesLink();
		courses.clickActionCourse("Test Course");
	}

}
