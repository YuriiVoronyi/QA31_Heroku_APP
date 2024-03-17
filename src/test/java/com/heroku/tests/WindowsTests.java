package com.heroku.tests;

import com.heroku.pages.HomePage;
import com.heroku.pages.MultiWindowsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTests extends TestBase{

    @BeforeMethod
    public void precondition() {

        new HomePage(driver).getWindows();
    }

    @Test
    public void selectNewTabTest() {
        new MultiWindowsPage(driver).switchToNextTab(1).verifyNewTabText("New Window");
    }

}
