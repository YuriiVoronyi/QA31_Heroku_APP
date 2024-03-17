package com.heroku.tests;

import com.heroku.pages.AlertsPage;
import com.heroku.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase{

    @BeforeMethod
    public void precondition() {

        new HomePage(driver).getAlerts();
    }

    @Test
    public void testForJSAlert() {
        new AlertsPage(driver).clickButtonAlert("OK").verifyResult("You successfully clicked an alert");
    }

    @Test
    public void testForJSConfirm() {
        new AlertsPage(driver).selectResult("Cancel").verifyResult("You clicked: Cancel");
    }

    @Test
    public void testForJSPrompt() {
        new AlertsPage(driver).clickButtonPrompt("Hallo").verifyResult("You entered: Hallo");
    }
}
