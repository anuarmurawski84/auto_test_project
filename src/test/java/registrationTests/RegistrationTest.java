package registrationTests;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    
    private String email = "235asfasf-123@yopmail.com";

    @Test
    public void testRegistrationValid() {
        //Setup browser
        File chrome = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            webDriver.get("http://automationpractice.com/index.php");
            logger.info("Open ulr - http://automationpractice.com/index.php");
        } catch (Exception e) {
            logger.error("Can't open url - http://automationpractice.com/index.php");
            Assert.fail("Can't open url - http://automationpractice.com/index.php");
        }

        //Your personal info
        webDriver.findElement(By.xpath("//a[@class='login']")).click();
//        webDriver.findElement(By.className("login")).click();
//        webDriver.findElement(By.cssSelector(".login")).click();
        logger.info("Click login - //a[@class='login']");
        webDriver.findElement(By.xpath("//input[@id='email_create']"))
                .sendKeys(email);
        logger.info("Input email - " + email);
        webDriver.findElement(By.name("SubmitCreate")).click();
//        webDriver.findElement(By.name("button[name$='SubmitCreate']")).click();
        logger.info("Click account create form");
        webDriver.findElement(By.id("customer_firstname"))
                .sendKeys("Dima");
        logger.info("Input customer firstname - Dima");
        webDriver.findElement(By.id("customer_lastname"))
                .sendKeys("Hulak");
        logger.info("Input customer lastname - Hulak");
        webDriver.findElement(By.id("email")).clear();
        webDriver.findElement(By.id("email")).sendKeys(email);
        logger.info("Input email - " + email);
        webDriver.findElement(By.id("passwd"))
                .sendKeys("qwerty123");
        logger.info("Input password - qwerty123");

        //your address
        webDriver.findElement(By.xpath("//input[@id='firstname']")).clear();
        webDriver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Dima");
        logger.info("Input first name - Dima");
        webDriver.findElement(By.xpath("//input[@id='lastname']")).clear();
        webDriver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Hulak");
        logger.info("input last name - Hulak");
        webDriver.findElement(By.xpath("//div[@class='account_creation']//p[4]//input[@type='text']"))
                .sendKeys("street New York, 12");
        webDriver.findElement(By.xpath("//input[@id='city']"))
                .sendKeys("New York");
        Select state = new Select(webDriver.findElement(By.id("id_state")));
        state.selectByIndex(32);
        logger.info("Select by index - 32");
        webDriver.findElement(By.cssSelector("#postcode"))
                .sendKeys("12345");
        logger.info("Input post code - 12345");
        webDriver.findElement(By.id("id_country")).isDisplayed();
        Select country = new Select(webDriver.findElement(By.id("id_country")));
        country.selectByVisibleText("United States");
        logger.info("Select by visible text - United States");
        webDriver.findElement(By.xpath("//input[@id='phone_mobile']"))
                .sendKeys("1234567890");
        logger.info("Input phone - 1234567890");
        webDriver.findElement(By.xpath("//input[@id='alias']")).clear();
        webDriver.findElement(By.xpath("//input[@id='alias']"))
                .sendKeys(email);
        logger.info("Input alias - " + email);
        webDriver.findElement(By.xpath("//button[@name='submitAccount']")).click();
        logger.info("Click button submit registration");
//        webDriver.findElement(By.xpath("//div[@id='center_column']/h1")).isDisplayed();
//        logger.info("Check h1 is displayed - //div[@id='center_column']/h1");

        //Close chromedriver
        webDriver.quit();
    }
}
