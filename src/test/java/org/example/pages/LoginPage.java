package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Sushant
 */
public class LoginPage {

    WebDriver ldriver;

    public LoginPage(WebDriver rDriver)
    {
        ldriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    @FindBy(id = "Email") WebElement textEmail;

    @FindBy(id = "Password") WebElement textPassword;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    WebElement loginBtn;


    @FindBy(linkText = "Logout")
    WebElement logoutLink;

    public void setUserEmail(String userName) {
        textEmail.clear();
        textEmail.sendKeys(userName);
    }

    public void setUserPass(String userPass) {
        textPassword.clear();
        textPassword.sendKeys(userPass);
    }

    public void clickLoginBt() {
        loginBtn.click();
    }

    public void clickLogOutLink() {
        logoutLink.click();
    }

}
