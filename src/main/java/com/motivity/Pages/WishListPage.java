package com.motivity.Pages;

import com.motivity.FrameworkActions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
    WebDriver driver;
    SeleniumActions seleniumActions;
    public WishListPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        seleniumActions = new SeleniumActions(driver);
    }

    @FindBy(xpath = "//div[@class='message info empty']/span")
    WebElement noItemsMessage;
    @FindBy(xpath = "//a[@class='action showcart active']/span/span[@class='counter-number']")
    WebElement myCartButton;
    @FindBy(xpath = "//button[@title='Proceed to Checkout']/parent::div[@class='primary']")
    WebElement proceedAndCheckOutButton;



    public String getThemessagefromePage(){
        return noItemsMessage.getText();
    }
    public void clickingOnCart(){
        seleniumActions.clickOnElement(myCartButton);
        seleniumActions.waitAndClickOnElement(proceedAndCheckOutButton);
    }
}
