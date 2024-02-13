package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Sushant
 */
public class ReadConfig {

    Properties properties;

    public ReadConfig() {
        File src = new File("./configurations/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            properties = new Properties();
            properties.load(fis);
        }
        catch (Exception e) {
            throw new RuntimeException("Exception is: " + e.getMessage());
        }

    }

    public String getBaseUrl() {
        String url = properties.getProperty("baseURL");
        return url;
    }

    public String getLoginUrl(){
        String url=properties.getProperty("loginURL");
        return url;
    }

    public String getProductPage(){
        String url= properties.getProperty("myAccountPageURL");
        return url;
    }

    public String getForgotPassUrl(){
        String url=properties.getProperty("forgotPassURL");
        return url;
    }

    public String getUser() {
        String user = properties.getProperty("validUser");
        return user;
    }

    public String getPass() {
        String pass = properties.getProperty("validPassword");
        return pass;
    }



    public String getChromeDriver() {
        String chromeDriver = properties.getProperty("chromeDriverPath");
        return chromeDriver;
    }
    public String getfireFoxDriver() {
        String fireFoxDriver = properties.getProperty("fireFoxDriverPath");
        return fireFoxDriver;
    }
}
