package test.UIAutomationDemo.FormData;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.UIAutomationDemo.Utils.JavaExecutor;
import test.UIAutomationDemo.Utils.Waits;

public class FormData1 {
    private WebDriver driver;
    Properties prop = new Properties();
    @BeforeTest
    public void setUp() throws InterruptedException 
    {

        try {
            FileReader reader = new FileReader("C:/Users/vineet.gulati/UIAutomation/demo1/src/test/java/test/UIAutomationDemo/Utils/setUp.properties");
            prop.load(reader);
            String URL = prop.getProperty("Url");
            System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get(URL);   
            }
             catch (Exception e) 
            {
            e.printStackTrace();
        }
    }

    @Test
    public  void formFill() throws InterruptedException{


           try{
            Waits wait = new Waits();
           // wait.setImplicitWait(driver, 20);
            driver.findElement(By.name("firstname")).sendKeys("Vineet");
            driver.findElement(By.name("lastname")).sendKeys("Gulati");
            driver.findElement(By.xpath("//input[@name='sex' and @value='Male']")).click();

            WebElement submitButton = driver.findElement(By.xpath("//button[@name='submit']"));
            WebElement nextButtonDown = driver.findElement(By.xpath("(//*[@class='nxt-btn'])[2]"));
            //Thread.sleep(5000);

            JavaExecutor.scrollToElement(driver, submitButton);
            WebElement exp = driver.findElement(By.xpath("//input[@name='exp' and @value='1']"));
            wait.waitForElementToBeClickable(driver, exp, 20);
            
            if (!exp.isSelected()) {
                exp.click();
            }

            LocalDate date = LocalDate.now();
            System.out.println(date);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
            String currentDate = date.format(formatter);
            System.out.println(currentDate);
            
            System.out.println("checking");
            
            wait.waitForElementToBeVisible(driver, By.xpath("(//*[@class='nxt-btn'])[2]"), 20);
            
           // Thread.sleep(3000);
            JavaExecutor.scrollToElement(driver, submitButton);

       
            driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(currentDate);

            Thread.sleep(3000);
            JavaExecutor.scrollToElement(driver, nextButtonDown);


            List<WebElement> checkboxes = driver.findElements(By.xpath("(//input[@name='tool'])"));
            for (WebElement checkbox : checkboxes) {
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
            }
       
            WebElement selectElement = driver.findElement(By.name("selenium_commands")); // Replace "selenium_commands" with the name attribute of the <select> element

            Select select = new Select(selectElement);
            select.selectByIndex(1);
            submitButton.click();
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }

    @AfterTest
    public void tearDown(){
              driver.quit();
      

    }
    
}
