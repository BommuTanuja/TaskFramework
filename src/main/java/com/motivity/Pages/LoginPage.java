package com.motivity.Pages;

import com.motivity.BasePage.ActionsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    ActionsPage actionsPage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        actionsPage = new ActionsPage(driver);

    }
    @FindBy(xpath = "(//li[@class='authorization-link']/a)[1]")
    WebElement signinButton;
    @FindBy(css = "#email")
    WebElement emialInputBox;
    @FindBy(css = "input[title='Password']")
    WebElement passwordInputBox;
    @FindBy(xpath = "//button[@class='action login primary']")
    WebElement submitButton;

    public void login(String email,String password){
            actionsPage.waitAndClickOnElement(signinButton);
            emialInputBox.sendKeys(email);
            passwordInputBox.sendKeys(password);
            actionsPage.clickOnElement(submitButton);
    }


}

