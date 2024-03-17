package com.heroku.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MultiWindowsPage extends BasePage{

    public MultiWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/windows/new']")
    WebElement newwindow;

    public MultiNewWindowPage switchToNextTab(int index) {
        click(newwindow);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return new MultiNewWindowPage(driver);
    }
}
