package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonSearchProductPage {

    private WebDriver driver;

    private By productIphone          = By.name("");
    private By moblileCategoryLinkEle = By.xpath("//*[@id=\"nav-xshop\"]/a[4]");
    private By productSearchFieldEle  = By.id("twotabsearchtextbox"); // ->>  //*[@id="twotabsearchtextbox"]
    private By searchButtonEle        = By.id("nav-search-submit-button");

    public AmazonSearchProductPage(WebDriver driver) {

        this.driver = driver;
    }


    public void getMobileCatgoryPage(){
        driver.findElement(moblileCategoryLinkEle).click();
    }


    public void searchProduct(String productValue) {
        driver.findElement(productSearchFieldEle).sendKeys(productValue);
        driver.findElement(searchButtonEle).click();
    }

    public void searchProductWithCost(String costValue) {
        driver.findElement(productSearchFieldEle).sendKeys(costValue);
        driver.findElement(searchButtonEle).click();
    }

    public void addTheProductToCart(){
        driver.findElement(productIphone).click();
    }

}
