package SelenideTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.TextReport;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pagesSelenide.MainPage;
import pagesSelenide.MyAccountPage;
import pagesSelenide.RegistrationPage;
import pagesSelenide.SigninPage;

import java.util.HashMap;
import java.util.Map;


@Listeners({ScreenShooter.class, TextReport.class})
public class BaseTest {
    public Faker faker = new Faker();

    public SigninPage signinPage = new SigninPage();
    public RegistrationPage registrationPage = new RegistrationPage();
    public MyAccountPage myAccountPage = new MyAccountPage();
    public MainPage mainPage = new MainPage();

    public void setUpBrowser(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
//         1 - Allow, 2 - block, 0 - default
        prefs.put("profile.default_content_setting_values.notifications", 1);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("disable-infobars");
        options.addArguments("--window-size=1920,1080");
        WebDriverRunner.setWebDriver(new ChromeDriver(options));
    }

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().browserVersion("92").setup();
        Configuration.browser = "chrome";
        Configuration.timeout = 8000;
        Configuration.baseUrl = "http://automationpractice.com";
        Configuration.screenshots = true;
        Configuration.savePageSource = true;
        Configuration.reopenBrowserOnFail = true;
        setUpBrowser();
        Selenide.open(Configuration.baseUrl);
    }
    @AfterClass
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
