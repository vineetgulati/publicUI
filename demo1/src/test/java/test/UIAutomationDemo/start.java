package test.UIAutomationDemo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class start {

    public static void main(String[] args) throws InterruptedException {

        try {
            // Set the path to the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");

            // Create ChromeOptions object
            ChromeOptions options = new ChromeOptions();

            // Create a new instance of ChromeDriver
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            // Navigate to the website
            driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm#");

            driver.findElement(By.name("firstname")).sendKeys("Vineet");
            driver.findElement(By.name("lastname")).sendKeys("Gulati");
            driver.findElement(By.xpath("//input[@name='sex' and @value='Male']")).click();

            WebElement submitButton = driver.findElement(By.xpath("//button[@name='submit']"));
            String buttonName = submitButton.getText();
            Point point = submitButton.getLocation();
             System.out.println(buttonName + "and" + point);
             WebElement nextButtonDown = driver.findElement(By.xpath("(//*[@class='nxt-btn'])[2]"));

           

            // Scroll to the 'exp' element
           scrollToElement(driver, submitButton);
           Thread.sleep(3000);

            WebElement exp = driver.findElement(By.xpath("//input[@name='exp' and @value='1']"));

            if (!exp.isSelected()) {
                exp.click();
            }

            LocalDate date = LocalDate.now();
            System.out.println(date);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
            String currentDate = date.format(formatter);
            System.out.println(currentDate);
            driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(currentDate);

            List<WebElement> checkboxes = driver.findElements(By.xpath("(//input[@name='tool'])"));
            for (WebElement checkbox : checkboxes) {
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
            }
            Thread.sleep(2000);
            scrollToElement(driver, nextButtonDown);

            Thread.sleep(1000);
            WebElement selectElement = driver.findElement(By.name("selenium_commands")); // Replace "selenium_commands" with the name attribute of the <select> element

            Select select = new Select(selectElement);
            select.selectByIndex(1);
            Thread.sleep(1000);
            submitButton.click();
            Thread.sleep(3000);


            driver.quit();
        } catch (ElementClickInterceptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'end', behavior: 'instant'});", element);
    }
    
}
