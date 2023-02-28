package com.motivity.Pages;

import com.motivity.BasePage.ActionsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    ActionsPage actionsPage;
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        actionsPage = new ActionsPage(driver);

    }

    @FindBy(xpath = "//span[text()='Gear']")
    WebElement gearButton;
    @FindBy(xpath = "//span[text()='Bags']")
    WebElement bagsButton;
    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement cartButton;
    @FindBy(xpath = "//div[@class='block-content']/strong[@class='subtitle empty']")
    WebElement emptyCart;
    @FindBy(xpath = "//div[@class='block-content']/button")
    WebElement cartCloseButton;


    public void clickOnGear(){
        actionsPage.moveToElement(gearButton);
        actionsPage.clickOnElement(bagsButton);

    }
    public void  verificationofCart(){

        actionsPage.clickOnElement(cartButton);
    }
    public String getTheCartText(){
        return emptyCart.getText();
    }
    public void closeTheCart()  {
        actionsPage.clickOnElement(cartCloseButton);

    }

}
