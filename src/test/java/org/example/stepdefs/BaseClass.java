package org.example.stepdefs;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import utils.ReadConfig;

/**
 * @author Sushant
 */
public class BaseClass {

    public static WebDriver          driver;
    public        LoginPage          loginPg;

    public static Logger     log;
    public static ReadConfig readConfig;
    //generate unique email id
    public String generateEmailId()
    {
        return(RandomStringUtils.randomAlphabetic(5));
    }
}
