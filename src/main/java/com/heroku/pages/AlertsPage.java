package com.heroku.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AlertsPage extends BasePage{

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[.='Click for JS Alert']")
    WebElement buttonOfAlert;

    public AlertsPage clickButtonAlert(String button) {
        click(buttonOfAlert);
        if(button != null && button.equals("OK")) {
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(xpath = "//button[.='Click for JS Confirm']")
    WebElement buttonOfConfirm;

    public AlertsPage selectResult(String confirm) {
        click(buttonOfConfirm);
        if(confirm != null && confirm.equals("OK")) {
            driver.switchTo().alert().accept();
        } else  if (confirm != null && confirm.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(xpath = "//button[.='Click for JS Prompt']")
    WebElement buttonOfPrompt;

    public AlertsPage clickButtonPrompt(String message) {
        click(buttonOfPrompt);
        if(message != null) {
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(id = "result")
    WebElement confirmResult;

    public AlertsPage verifyResult(String result) {
        Assert.assertTrue(confirmResult.getText().contains(result));
        return this;
    }
}
