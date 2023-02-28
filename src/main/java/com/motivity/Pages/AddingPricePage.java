package com.motivity.Pages;


import com.motivity.BasePage.ActionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddingPricePage {
    WebDriver driver;
    ActionsPage actionsPage;


    public AddingPricePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        actionsPage = new ActionsPage(driver);
    }
    @FindBy(xpath = "//a[@class='action towishlist']/span")
    WebElement wishListButton;
    @FindBy(xpath = "(//strong[@class='product-item-name']/a)[1]")
    WebElement priceText;

    @FindBy(xpath = "//button[@title='Add All to Cart']/span")
    WebElement addToCartButton;


    public void getHighestprice() throws InterruptedException {

        List<Float> newPricesList = new ArrayList<>();
        List<WebElement> priceList = driver.findElements(By.xpath("//strong[@class='product name product-item-name']/following-sibling::div[@class='price-box price-final_price']"));

        for (int i = 0; i < priceList.size(); i++) {
            String prices = priceList.get(i).getText();
         String priceValue = prices.replace("Special Price","");
         String newPrices = priceValue.replace("Regular Price $32.00","");
         String priceValues = newPrices.replace("$","");
         //System.out.println(priceValues);

         Float allPrices = Float.parseFloat(priceValues);
         newPricesList.add(allPrices);

        }
       // System.out.println(newPricesList);
        Float maxValue = Collections.max(newPricesList);
        System.out.println(maxValue);

        WebElement itempriceName = driver.findElement(By.xpath("//span[contains(text(),'"+maxValue+"')]/../../../../strong[@class='product name product-item-name']"));
        String pricename = itempriceName.getText();
        System.out.println(pricename);
        actionsPage.clickOnElement(itempriceName);



    }

    public void addingtowishList()
    {
        actionsPage.waitAndClickOnElement(wishListButton);
    }

    public String getwishListName()
    {
        return priceText.getText();
    }
    public void clickOnCartButton(){
        actionsPage.clickOnElement(addToCartButton);


    }




}
