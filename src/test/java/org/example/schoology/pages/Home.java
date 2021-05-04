package org.example.schoology.pages;

import org.example.core.Environment;
import org.example.schoology.Resources;
import org.openqa.selenium.By;

import org.example.core.ui.AbstractPage;

import java.util.ResourceBundle;

public class Home extends AbstractPage {

    /**
     * This only works for Courses and Groups
     * Resources and More menu has another behavior.
     *
     * @param keyMenuName {courses or groups}
     * @return {@link SubMenu}
     */
    public SubMenu clickMenu(final String keyMenuName) {
        //verify if it is from courses
        ResourceBundle bundle = ResourceBundle.getBundle(Resources.I18N_COURSE,
                Environment.getInstance().getLocale());
        if(bundle.containsKey(keyMenuName))
        {
            String menuName = bundle.getString(keyMenuName);
            action.jsClick(driver.findElement(By.xpath(String.format("//span[text()='%s']/parent::button", keyMenuName))));
            return new SubMenu();
        }
        bundle = ResourceBundle.getBundle(Resources.I18N_RESOURCE,
                Environment.getInstance().getLocale());
        if(bundle.containsKey(keyMenuName))
        {
            String menuName = bundle.getString(keyMenuName);
            action.jsClick(driver.findElement(By.xpath(String.format("//li/a[text()='%s']", menuName))));
        }
        return new SubMenu();
    }

}
