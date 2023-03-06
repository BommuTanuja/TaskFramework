package com.motivity.SuccessfulTests;


import com.motivity.Automation.BasePage;
import com.motivity.DataManager.ReadDataFromJson;
import com.motivity.Pages.*;

import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class MagentoTest extends BasePage {
    public LoginPage loginPage;
    public HomePage homePage;
    public AddingPricePage addingPricePage;
    public WishListPage wishListPage;
    public ShippingAddressPage shippingAddressPage;
    public  ReadDataFromJson readDataFromJson;



    @BeforeClass
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


        loginPage.login(readDataFromJson.readValueFromJson("email"),
                readDataFromJson.readValueFromJson("password"));
        homePage.clickOnGear();
        homePage.verificationOfCart();
        String actualTitle = homePage.getTheCartText();
        String expectedTitle ="You have no items in your shopping cart.";
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println(actualTitle);
        homePage.closeTheCart();
        Thread.sleep(1000);
        addingPricePage.getHighestprice();
        addingPricePage.addingtowishList();
        String nameToBePresentOnWishList = addingPricePage.getwishListName();
        Assert.assertEquals(nameToBePresentOnWishList,readDataFromJson.readValueFromJson("priceName"));
        addingPricePage.clickOnCartButton();
        String message = wishListPage.getThemessagefromePage();
        Assert.assertEquals(message,readDataFromJson.readValueFromJson("wishlistMessage"));
        wishListPage.clickingOnCart();
        shippingAddressPage.givingStreetAddress(readDataFromJson.readValueFromJson("StreetAddress"),
                    readDataFromJson.readValueFromJson("City"),readDataFromJson.readValueFromJson("Zipcode")
                 ,readDataFromJson.readValueFromJson("phone"));
       // shippingAddressPage.clickOnNextButton();
        shippingAddressPage.clickOnPlaceOrder();
        String actualDate = shippingAddressPage.getOrderDate();
        Assert.assertEquals(actualDate,readDataFromJson.readValueFromJson("orderDate"));
        String actualFinalPrice = shippingAddressPage.getFinalPrice();
        Assert.assertEquals(actualFinalPrice,readDataFromJson.readValueFromJson("price"));





    }

}
