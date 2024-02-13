package org.example.stepdefs;

import Utils.ReadConfig;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.AmazonSearchProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AmazonSearchProductPageSetpDef {
    private WebDriver  driver;
    private ReadConfig readConfig               = new ReadConfig() ;
    public  String     IdentifiedProductElement =" ";
    private String mobileCategoryExpectedLink="https://www.amazon.in/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles";
    private String findIphoneExpectedLink="https://www.amazon.in/s?k=Apple+iPhone+14+Plus+%28128+GB%29+-+%28Product%29+RED&rh=n%3A1389401031&ref=nb_sb_noss";
    private AmazonSearchProductPage searchProductPage= new AmazonSearchProductPage(driver);







    @Given("I am on the amazon page")
    public void iAmOnSearchProductPage() {

        driver.get(readConfig.getBaseUrl());
    }


    @Given("User is selected the Mobile category")
    public void userWillSelectTheMobileCategory() {
        searchProductPage.getMobileCatgoryPage();
    }

    @Then("User will navigate to mobile Category page")
    public void userWillNavigateToMobilePage() {
        Assert.assertEquals(driver.getCurrentUrl() , mobileCategoryExpectedLink);
    }

    @Given("User searches for {string}")
    public void userSearchesFor(String product) {
        searchProductPage.searchProduct(product);

    }

    @Then("Search result are displayed")
    public void searchResultAreDisplayed() {
        Assert.assertEquals(driver.getCurrentUrl() ,findIphoneExpectedLink);
    }

    @When("User need to identify {string} with {string}")
    public void userNeedToIdentifyWith(String productValue,String costValue) {
        searchProductPage.searchProduct(productValue);
        searchProductPage.searchProductWithCost(costValue);
    }

    @Then("user add the product in cart")
    public void userAddTheProductInCart() {
        searchProductPage.addTheProductToCart();
    }
}
