package com.company.step_definitions;

import com.company.pages.LoginPageZeroBank;
import com.company.utilities.ConfigurationReader;
import com.company.utilities.Driver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginToZeroBank {

    LoginPageZeroBank loginPageZeroBank = new LoginPageZeroBank();
    WebDriver driver;

    @When("The user navigates to the login page")
    public void the_user_navigates_to_the_login_page() {

        String url = ConfigurationReader.getProperty("bankUrl");
        Driver.getDriver().get(url);
    }
    @Then("user logs in with the user {string} and the password {string}")
    public void user_logs_in_with_the_user_and_the_password(String username, String password) {

        loginPageZeroBank.loginButtom.sendKeys(username);
        loginPageZeroBank.passwordButtom.sendKeys(password);
        loginPageZeroBank.signInButtom.click();
        loginPageZeroBank.securyButtom.click();
    }

    @Then("The user navigates to Account Activity page")
    public void the_user_navigates_to_account_activity_page() {
        loginPageZeroBank.accountActivityLink.click();

    }
    @Then("Then The page should have the title {string}")
    public void then_the_page_should_have_the_title(String string) {
        String expectedTitle = "Zero - Account Activity";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Zero - Account Activity");
    }

    @Then("Then Account drop down should have the following options")
    public void then_account_drop_down_should_have_the_following_options() {

        Select dropDown = new Select(loginPageZeroBank.accountsDropDown);

        List<String> expectedOptions = new ArrayList<>(Arrays.asList("Savings", "Checking", "Savings", "Loan",
                "Credit Card", "Brokerage"));
        List<WebElement> actualOptions = dropDown.getOptions();

        List<String> actualOptionsTexts = new ArrayList<>();
        for (WebElement actualOption : actualOptions) {
            actualOptionsTexts.add(actualOption.getText());
        }

        System.out.println("expectedOptions = " + expectedOptions);
        System.out.println("actualOptions = " + actualOptions);
        System.out.println("actualOptionsTexts = " + actualOptionsTexts);

        Assert.assertEquals("verify Dropdown Options", actualOptionsTexts, expectedOptions);


    }
    @Then("Brokerage option should have {string}")
    public void brokerage_option_should_have(String string) {
        Select dropDown = new Select(loginPageZeroBank.accountsDropDown);
        dropDown.selectByVisibleText("Brokerage");

        String expectedText = "No results.";
        String actualText = loginPageZeroBank.noResultAnswer.getText();

        Assert.assertEquals(actualText,expectedText,"No results.");

        //added
    }
}
