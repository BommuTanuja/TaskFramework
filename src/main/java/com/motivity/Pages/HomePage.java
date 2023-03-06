package com.motivity.Pages;

import com.motivity.FrameworkActions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    SeleniumActions seleniumActions;
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        seleniumActions = new SeleniumActions(driver);

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
        Actions actions = new Actions(driver);
        actions.moveToElement(gearButton).click().build().perform();
        seleniumActions.clickOnElement(bagsButton);

    }
    public void  verificationOfCart(){

        seleniumActions.clickOnElement(cartButton);
    }
    public String getTheCartText()
    {
        return emptyCart.getText();
    }
    public void closeTheCart()  {
        seleniumActions.clickOnElement(cartCloseButton);

    }

}
