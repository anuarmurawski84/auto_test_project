package baseTest;

import com.github.javafaker.Faker;
import libs.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.MainPage;
import pages.RegistrationPage;

import java.io.File;
import java.util.concurrent.TimeUnit;



public class BaseTest {
    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    public Faker faker;
    public Utils utils = new Utils();
    public String patchToScreenShot;
    public String browser;

    public RegistrationPage registrationPage;
    public MainPage mainPage;

    public BaseTest(){
    }

    @Parameters("browser")
    @BeforeClass
    public void setUp(){
        File chrome = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        File file = new File("");
        patchToScreenShot = file.getAbsolutePath() + "\\resources\\screenshot" +
                this.getClass().getPackage().getName() + "\\" +
                this.getClass().getSimpleName() + ".png";


        registrationPage = new RegistrationPage(webDriver);
        faker = new Faker();

        try{
            webDriver.get("http://automationpractice.com");
            logger.info("Open url - automationpractice.com");
        } catch (Exception e){
            logger.error("Can't open URL");
            Assert.fail("Can't open URL");
        }
    }

    @AfterClass
    public void tearDown(){
        if (!(webDriver==null)){
            utils.screenShot(patchToScreenShot, webDriver);
            webDriver.quit();
        }
    }
    public void checkAC(boolean actual, boolean expected){
        Assert.assertEquals(actual, expected);
    }
}
