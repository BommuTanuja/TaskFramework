package com.motivity.SuccessfulTests;


import com.motivity.BasePage.WebPage;
import com.motivity.DataManager.ReadDataFromJson;
import com.motivity.Pages.*;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;



public class MagentoTest extends WebPage {
    public LoginPage loginPage;
    public HomePage homePage;
    public AddingPricePage addingPricePage;
    public WishListPage wishListPage;
    public ShippingAddressPage shippingAddressPage;
    public  ReadDataFromJson readDataFromJson;



    @BeforeTest
    public void initializeThePage(){
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    addingPricePage = new AddingPricePage(driver);
    wishListPage = new WishListPage(driver);
    shippingAddressPage = new ShippingAddressPage(driver);
    readDataFromJson = new ReadDataFromJson();

    }

    @Test
    public void verifyingTheTests() throws InterruptedException {

        readDataFromJson.readValueFromJson("email");   // json

        loginPage.login("tanuja.bommu12@gmail.com","Tanuja@12");
        homePage.clickOnGear();
        homePage.verificationofCart();
        String actualTitle = homePage.getTheCartText();
        Assert.assertEquals(actualTitle,"You have no items in your shopping cart.");
        System.out.println(actualTitle);
        homePage.closeTheCart();
        Thread.sleep(1000);
        addingPricePage.getHighestprice();
        addingPricePage.addingtowishList();
        String nameToBePresentOnWishList = addingPricePage.getwishListName();
        Assert.assertEquals(nameToBePresentOnWishList,"Impulse Duffle");
        addingPricePage.clickOnCartButton();
        String message = wishListPage.getThemessagefromePage();
        Assert.assertEquals(message,"You have no items in your wish list.");
        wishListPage.clickingOnCart();
        // shippingAddressPage.givingStreetAddress("2-44b,main road,2nd block","Dallas","12345","1234567891");
        shippingAddressPage.clickOnNextButton();
        shippingAddressPage.clickOnPlaceOrder();


    }

}
