package baseTest;

import com.github.javafaker.Faker;
import libs.Utils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainPage;
import pages.RegistrationPage;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;

@RunWith(value = Parameterized.class)
public class BaseTest {
    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    public Faker faker;
    public Utils utils = new Utils();
    public String patchToScreenShot;
    public String browser;

    public RegistrationPage registrationPage;
    public MainPage mainPage;

    public BaseTest(String browser){
        this.browser = browser;
    }

//    Iterable instead of Collection for int
    @Parameterized.Parameters
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"chrome"},
                {"firefox"}
        });
    }


    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp(){
        if ("chrome".equals(browser)){
            logger.info(browser + "will be started");
            File chrome = new File("./drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
            webDriver = new ChromeDriver();
            logger.info(browser + " is started");
        } else if ("firefox".equals(browser)){
            logger.info(browser + "will be started");
            File firefox = new File("./drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", firefox.getAbsolutePath());
            webDriver = new FirefoxDriver();
            logger.info(browser + " is started");
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        File file = new File("");
        patchToScreenShot = file.getAbsolutePath() + "\\resources\\screenshot" +
                this.getClass().getPackage().getName() + "\\" +
                this.getClass().getSimpleName() + "\\" + this.testName.getMethodName() +
                "-" + browser + ".png";


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

    @After
    public void tearDown(){
        if (!(webDriver==null)){
            utils.screenShot(patchToScreenShot, webDriver);
            webDriver.quit();
        }
    }
    public void checkAC(String message, boolean actual, boolean expected){
        Assert.assertThat(message, actual, is(expected));
    }
}
