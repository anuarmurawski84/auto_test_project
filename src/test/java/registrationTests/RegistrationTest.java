package registrationTests;

import baseTest.BaseTest;
import org.junit.Test;


import java.io.File;
import java.util.concurrent.TimeUnit;

public class RegistrationTest extends BaseTest {

    private final String FIRST_NAME = "Dima";
    private final String LAST_NAME = "Hulak";
//    private final String EMAIL = "34sss46-sdgsdgs@yopmail.com";
    private final String PASSWORD = "qwerty123";
    private final String STREET = "street New York, 12";
    private final String CITY = "New York";
    private final String CITY_INDEX = "New York";
    private final String POST_CODE = "12345";
    private final String COUNTRY = "United States";
    private final String PHONE_MOBILE = "1234567890";

    public RegistrationTest(String browser) {
        super(browser);
    }


    @Test
    public void testRegistration() {
        //Your personal info
        registrationPage.openRegistrationPage();
        registrationPage.inputEmailCreate(faker.internet().emailAddress());
        registrationPage.submitButtonCreate();
        //another method
        registrationPage.inputCustomerFN(FIRST_NAME);
        registrationPage.inputCustomerLN(LAST_NAME);
        registrationPage.inputEmail(faker.internet().emailAddress());
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
        registrationPage.inputAlias(faker.internet().emailAddress());
        registrationPage.clickSubmitAccount();
        checkAC("Text is present",
                registrationPage.titleRegisteredAccount.isDisplayed(),
                true);
        //Asserts
//        registrationPage.checkTitle("Title",
//                registrationPage.checkTitleTextOnPage("My account - My Store"),
//                true);
//        registrationPage.checkTitle("Title",
//                registrationPage.checkElementPresent()
//

    }
}
