package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    private By emailInputLocator            = By.name("email");
    private By passwordInputLocator         = By.name("password");
    private By loginButtonLocator           = By.xpath("//div[@class=\"nav-signin-tt nav-flyout\"]//child::span[@class=\"nav-action-inner\"]");
    private By forgottenPasswordLinkLocator = By.xpath("//a[@id=\"auth-fpp-link-bottom\"]");

    private By needHelpLinklocator= By.xpath("//span[@class=\"a-expander-prompt\"]");
    private By logoutLinkLocator            = By.xpath("//*[text()=\"Sign Out\"][@class=\"nav-text\"]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void getLoginPage(String endpoint){
        driver.get(endpoint);
    }

    public void enterEmail(String email) {
        WebElement elementInput = driver.findElement(emailInputLocator);
        elementInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public boolean clickLogOutButton() {
        WebElement logOutButton = driver.findElement(logoutLinkLocator);
        logOutButton.click();
        return false;
    }

    public void clickOnNeedHelpLink(){
        WebElement needHelpLink = driver.findElement(needHelpLinklocator);
        needHelpLink.click();
    }

    public void clickOnForgotLink(){
        WebElement forgottenLink = driver.findElement(forgottenPasswordLinkLocator);
        forgottenLink.click();
    }


    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }


}
