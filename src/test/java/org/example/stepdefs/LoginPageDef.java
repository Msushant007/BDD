package org.example.stepdefs;

import Utils.ReadConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class LoginPageDef {

    private WebDriver driver;
    private LoginPage loginPage;

    private ReadConfig readConfig= new ReadConfig() ;


    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", readConfig.getChromeDriver());
        driver = new ChromeDriver();

    }

   /* @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }*/
    @Given("User on login page")
    public void iCanGetLoginPage(){
        loginPage.getLoginPage(readConfig.getBaseUrl());
    }


    @When("I click on the Forgotten Password link")
    public void iClickOnLink() {
        loginPage.clickOnForgotLink();
    }

    @Then("I should redirected to password reset page")
    public void iShouldRedirectedToPasswordResetPage() {
        Assert.assertEquals(driver.getCurrentUrl(), readConfig.getForgotPassUrl());
    }

    @Given("I am on the OpenCart login page")
    public void i_am_on_the_OpenCart_login_page() {
        iClickOnLoginButton();
        loginPage = new LoginPage(driver);
    }

    @Given("I have entered valid username and password")
    public void iHaveEnteredValidUsernameAndPassword() {
        loginPage.enterEmail("qatestertest@gmail.com");
        loginPage.enterPassword("Test@123");
    }

    @When("I click on login button")
    public void iClickOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should logged in successfully")
    public void iShouldLoggedInSuccessfully() {
        Assert.assertEquals(driver.getCurrentUrl(), readConfig.getProductPage());
    }


    @Given("I have entered valid username and password for logout test")
    public void iHaveEnteredValidUsernameAndPasswordForLogoutTest() {
    }

    @When("I click on logout button")
    public void iClickOnLogoutButton() {
        loginPage.clickLogOutButton();
    }

    @Then("I should logout successfully")
    public void iShouldLogoutSuccessfully() {
        Assert.assertEquals(driver.getCurrentUrl(), readConfig.getLoginUrl());
    }

    @Given("I have entered invalid {string} and {string}")

    public void iHaveEnteredInvalidAnd(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);

    }

    @When("I click on logins button")
    public void iClickOnLoginsButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should seen a error message indicating {string}")
    public void iShouldSeenAErrorMessageIndicating(String error_message) {
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);
    }


}
