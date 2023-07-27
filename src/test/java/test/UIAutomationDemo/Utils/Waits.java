package test.UIAutomationDemo.Utils;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Waits {
    WebDriver driver;
     public void setImplicitWait(WebDriver driver,int Timeout)
    {
      driver.manage().timeouts().implicitlyWait( Timeout,TimeUnit.SECONDS);
    }

    public void waitForElementToBeClickable(WebDriver driver, WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForElementToBeVisible(WebDriver driver, By locator, int seconds) 
    {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    }

