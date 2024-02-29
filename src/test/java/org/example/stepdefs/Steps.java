package org.example.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.example.pages.LoginPage;
import org.junit.Assert;
import utils.DriverSetup;
import utils.ReadConfig;
import utils.WaitUtils;

public class Steps extends BaseClass {

    public WaitUtils waitUtils = new WaitUtils();

    @Before
    public  static void setUp() throws IOException {

        readConfig = new ReadConfig();

        //initialise logger
        log = LogManager.getLogger("StepDef");

        System.out.println("Setup-Sanity method executed..");

        driver = DriverSetup.getInstance().webDriverOpen(readConfig.getBrowser());

        log.fatal("Setup1 executed...");

    }

    @Given("^User Launch the Chrome browser")
    public void user_launch_the_chrome_browser() {
        loginPg = new LoginPage(driver);
        log.info("chrome browser launched");
    }

    @When("User open URL {string}")
    public void user_open_URL(String url) {
        // Write code here that turns the phrase above into concrete actions
        driver.get(url);
        log.info("url opened");
    }

    @When("User Enters Email As {string} and Password as {string}")
    public void user_Enters_Email_As_and_Password_as(String UserName, String UserPass) {

        loginPg.setUserEmail(UserName);
        loginPg.setUserPass(UserPass);
        log.info("email address and password entered");

    }

    @When("Click on Login button")
    public void click_on_Login_button() {
        loginPg.clickLoginBt();
        log.info("Clicked on login button");
    }

    @Then("Page Title should be {string}")
    public void page_Title_should_be(String expTitle) {
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expTitle)) {
            log.warn("Test passed: Login feature :Page title matched.");

            Assert.assertTrue(true);//pass
        } else {
            Assert.assertTrue(false);//fail
            log.warn("Test Failed: Login feature- page title not matched.");

        }

    }

    @When("User Click on Logout link")
    public void user_Click_on_Logout_link() {
        loginPg.clickLogOutLink();
    }

    @Then("After Logout Page Title should be {string}")
    public void after_logout_page_Title_should_be(String expTitle) {

        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expTitle)) {
            log.warn("Test passed: Logout feature :Page title matched.");

            Assert.assertTrue(true);//pass
        } else {
            Assert.assertTrue(false);//fail
            log.warn("Test Failed: Logout feature- page title not matched.");

        }
    }

}








