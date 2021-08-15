package registrationTests;

import baseTest.BaseTest;
import dataProviders.RegistrationPageDataProvider;
import model.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    private final String FIRST_NAME = "Edward";
    private final String LAST_NAME = "Asan";
//    private final String EMAIL = "34sss46-sdgsdgs@yopmail.com";
    private final String PASSWORD = "qwerty123";
    private final String STREET = "street New York, 12";
    private final String CITY = "New York";
    private final String CITY_INDEX = "New York";
    private final String POST_CODE = "12345";
    private final String COUNTRY = "United States";
    private final String PHONE_MOBILE = "1234567890";


    @Test
    public void testRegistration() {
        signinPage.clickToSingIn();
        signinPage.inputEmailCreate(faker.internet().emailAddress());
        registrationPage.submitButtonCreate();
        registrationPage.inputFromAccount();
        registrationPage.inputCustomerFN(FIRST_NAME);
        registrationPage.inputCustomerLN(LAST_NAME);
        registrationPage.inputEmail(faker.internet().emailAddress());
        registrationPage.inputPassword(PASSWORD);
        registrationPage.inputFirstName(FIRST_NAME);
        registrationPage.inputLastName(LAST_NAME);
        registrationPage.inputAddressByDefault(STREET);
        registrationPage.inputCity(CITY);
        registrationPage.selectCity(CITY_INDEX);
        registrationPage.inputPostCode(POST_CODE);
        registrationPage.selectCountry(COUNTRY);
        registrationPage.inputMobilePhone(PHONE_MOBILE);
        registrationPage.inputAlias(faker.internet().emailAddress());
        registrationPage.clickSubmitAccount();
        myAccountPage.getHeaderName("My account");
        checkAC(myAccountPage.titleRegisteredAccount.isDisplayed(),
                true);
    }

    @Test(dataProvider = "registrationNewUser", dataProviderClass = RegistrationPageDataProvider.class)
    public void testCreateAccount(Account userAccount){
        signinPage.clickToSingIn();
        signinPage.inputEmailCreate(faker.internet().emailAddress());
        registrationPage.submitButtonCreate();
        registrationPage.registrationUser(userAccount);
        registrationPage.clickSubmitAccount();
        checkAC(myAccountPage.titleRegisteredAccount.isDisplayed(),
                true);
        Assert.assertEquals(myAccountPage.getAccountName(),
                userAccount.getFirstCustomerName() + " " + userAccount.getLastCustomerName());
    }
}
