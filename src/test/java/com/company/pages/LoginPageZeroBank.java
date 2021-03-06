package com.company.pages;

import com.company.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageZeroBank {
    public LoginPageZeroBank(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "user_login")
    public WebElement loginButtom;

    @FindBy (id = "user_password")
    public WebElement passwordButtom;
    @FindBy (id = "user_login")
    public WebElement login;
    @FindBy (id = "user_login")
    public WebElement log;


    @FindBy (id="primary-button")
    public WebElement securyButtom;

    @FindBy (id="account_activity_link")
    public WebElement accountActivityLink;

    @FindBy(className = "well")
    public WebElement noResultAnswer;
    @FindBy (name = "submit")
    public WebElement signInButtom;
}
