package com.heroku.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@href='/javascript_alerts']")
    WebElement linkalerts;

    public AlertsPage getAlerts() {
        click(linkalerts);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//a[@href='/windows']")
    WebElement linkwindows;

    public MultiWindowsPage getWindows() {
        click(linkwindows);
        return new MultiWindowsPage(driver);
    }
}
