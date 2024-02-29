package utils;

import com.google.common.base.Function;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sushant
 */
public class WaitUtils {

    public WebDriverWait waitToLocatorToBeClickable(WebDriver driver, int second, final By locator) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return wait;
    }

    public WebDriverWait waitToWebElementToBeClickable(WebDriver driver, int second, final WebElement webElement) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return wait;
    }

    public WebDriverWait waitToElementToBeVisible(WebDriver driver, int second, final By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return wait;
    }

    public WebElement fluentWaitForElement(WebDriver driver, int waitSecond, int pollingSecond, final By locator)
    {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(1)).pollingEvery(
                Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);

            }
        });

    return webElement;

    }

}

