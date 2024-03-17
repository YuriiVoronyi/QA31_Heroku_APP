package com.heroku.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MultiNewWindowPage extends BasePage{

    public MultiNewWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[.='New Window']")
    WebElement title;

    public MultiNewWindowPage verifyNewTabText(String newWindow) {
        Assert.assertTrue(shouldHaveText(title,newWindow,15));
        return this;
    }

    private boolean shouldHaveText(WebElement element, String text, int index) {
        return new WebDriverWait(driver, Duration.ofSeconds(index))
                .until(ExpectedConditions.textToBePresentInElement(element,text));
    }
}
