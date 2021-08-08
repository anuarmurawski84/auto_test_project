package registrationTests;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.RegistrationPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());

    public RegistrationPage registrationPage;
    public MainPage mainPage;

    private final String FIRST_NAME = "Dima";
    private final String LAST_NAME = "Hulak";
    private final String EMAIL = "34sss46-sdgsdgs@yopmail.com";
    private final String PASSWORD = "qwerty123";
    private final String STREET = "street New York, 12";
    private final String CITY = "New York";
    private final int CITY_INDEX = 32;
    private final String POST_CODE = "12345";
    private final String COUNTRY = "United States";
    private final String PHONE_MOBILE = "1234567890";

    @Test
    public void testRegistration() {
        //Setup browser
        File chrome = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        webDriver = new ChromeDriver();
        registrationPage = new RegistrationPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Your personal info
        registrationPage.openRegistrationPage();
        registrationPage.inputEmailCreate(EMAIL);
        registrationPage.submitButtonCreate();
        //another method
        registrationPage.inputCustomerFN(FIRST_NAME);
        registrationPage.inputCustomerLN(LAST_NAME);
        registrationPage.inputEmail(EMAIL);
        registrationPage.inputPassword(PASSWORD);
        //your address
        registrationPage.inputFirstName(FIRST_NAME);
        registrationPage.inputLastName(LAST_NAME);
        registrationPage.inputStreet(STREET);
        registrationPage.inputCity(CITY);
        registrationPage.selectCity(CITY_INDEX);
        registrationPage.inputPostCode(POST_CODE);
        registrationPage.selectCountry(COUNTRY);
        registrationPage.inputMobilePhone(PHONE_MOBILE);
        registrationPage.inputAlias(EMAIL);
        registrationPage.clickSubmitAccount();
        //Asserts
        registrationPage.checkTitle("Title",
                registrationPage.checkTitleTextOnPage("My account - My Store"),
                true);
        registrationPage.checkTitle("Title",
                registrationPage.checkElementPresent()
                , true);
        //Close chromedriver
        webDriver.quit();
    }
}
