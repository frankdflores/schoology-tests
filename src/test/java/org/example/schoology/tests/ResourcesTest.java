package org.example.schoology.tests;

/**
 * @author Benjamin Huanca on 7/14/2020.
 * @version 1.0
 */

import org.example.schoology.pages.*;
import org.junit.Test;
public class ResourcesTest {
    @Test
    public void deleteQuestionBank() {

        Login login = new Login();
        Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
        Resources resourcePage = home.clickMenuResource("Resources");
        resourcePage.addResource();
        resourcePage.addQuestionBank();

        String questionBankName = PREFIX_AT + "question bank" + System.currentTimeMillis();


    }
}
