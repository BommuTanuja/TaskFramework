package com.motivity.Pages;

import com.motivity.BasePage.ActionsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddressPage {
    WebDriver driver;
    ActionsPage actionsPage;
    public ShippingAddressPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver = driver;
        actionsPage = new ActionsPage(driver);

    }

    @FindBy(name= "street[0]")
    WebElement streetAddressLabel;
    @FindBy(name = "city")
    WebElement cityLabel;
    @FindBy(xpath = "//span[text()='State/Province']/parent::label/following-sibling::div/select[@class='select']")
    WebElement stateLabel;
    @FindBy(name="postcode")
    WebElement postalCodeLabel;
    @FindBy(name = "country_id")
    WebElement countryLabel;
    @FindBy(name = "telephone")
    WebElement phoneLabel;

    @FindBy(xpath = "(//input[@class='radio'])[2]")
    WebElement radioButton;
    @FindBy(xpath = "//button[@class='button action continue primary']/span[text()='Next']")
    WebElement nextButton;
    @FindBy(xpath = "//span[text()='Place Order']")
    WebElement orderButton;
    @FindBy(xpath = "//a[@class='order-number']")
    WebElement orderNumberButton;

//    public void givingStreetAddress(String addressLine,String city,String zipcode,String phoneNumber) throws InterruptedException {
//
//        streetAddressLabel.sendKeys(addressLine);
//        cityLabel.sendKeys(city);
//
//        Select selectState = new Select(stateLabel);
//        selectState.selectByVisibleText("Texas");
//        postalCodeLabel.sendKeys(zipcode);
//        phoneLabel.sendKeys(phoneNumber);
//        actionsPage.clickOnElement(nextButton);
//
//    }
    public void clickOnNextButton(){
        actionsPage.clickOnElement(radioButton);
        actionsPage.clickOnElement(nextButton);

    }
    public void clickOnPlaceOrder(){
        actionsPage.clickOnElement(orderButton);
        actionsPage.clickOnElement(orderNumberButton);
    }



}
