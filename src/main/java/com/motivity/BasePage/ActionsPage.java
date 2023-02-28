package com.motivity.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ActionsPage {
    WebDriver driver;
    WaitsPage waitsPage;
    public ActionsPage(WebDriver driver){
        this.driver = driver;
        waitsPage = new WaitsPage(driver);
    }

    public boolean waitAndClickOnElement(WebElement element){
        try{
           waitsPage .waitForElementToBeClickable(element).click();
            return true;
        }catch (Exception e){

            return false;
        }
    }
    public void clickOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveToElement(WebElement element){
        try{
            element.click();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
