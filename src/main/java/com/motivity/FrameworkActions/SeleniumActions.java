package com.motivity.FrameworkActions;

import com.motivity.FrameworkWaits.SeleniumWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumActions {
    WebDriver driver;
    SeleniumWaits seleniumWaits;
    public SeleniumActions(WebDriver driver){
        this.driver = driver;
        seleniumWaits = new SeleniumWaits(driver);
    }
        /**
         *  wait and click on element
        *
        */
    public boolean waitAndClickOnElement(WebElement element){
        try{
            seleniumWaits .waitForElementToBeClickable(element).click();
            return true;
        }catch (Exception e){

            return false;
        }
    }

    /**
     *  click on element
     */
    public void clickOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
