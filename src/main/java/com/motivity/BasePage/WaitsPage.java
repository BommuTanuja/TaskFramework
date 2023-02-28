package com.motivity.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitsPage {
   WebDriverWait webDriverWait;

    public WaitsPage(WebDriver driver)
    {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    /**
     *  wait for element to be clickable
     *
     * return webelement
     */

    public WebElement waitForElementToBeClickable(WebElement element){
       return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
