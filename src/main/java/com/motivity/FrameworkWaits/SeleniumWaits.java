package com.motivity.FrameworkWaits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWaits {
   WebDriverWait webDriverWait;

    public SeleniumWaits(WebDriver driver)
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
