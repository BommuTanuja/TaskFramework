package com.motivity.Pages;

import com.motivity.BasePage.ActionsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
    WebDriver driver;
    ActionsPage actionsPage;
    public WishListPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        actionsPage = new ActionsPage(driver);
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
        actionsPage.clickOnElement(myCartButton);
        actionsPage.waitAndClickOnElement(proceedAndCheckOutButton);
    }
}
