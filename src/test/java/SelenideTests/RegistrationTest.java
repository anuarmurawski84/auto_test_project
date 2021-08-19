package SelenideTests;

import com.codeborne.selenide.Condition;
import dataProviders.RegistrationPageDataProvider;
import model.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    @Test(dataProvider = "registrationNewUser", dataProviderClass = RegistrationPageDataProvider.class)
    public void testCreateNewAccount(Account userAccount){
        signinPage.clickToSignIn();
        signinPage.inputEmailCreate(faker.internet().emailAddress());
        registrationPage.submitButtonCreate();
        registrationPage.registrationUser(userAccount);
        registrationPage.clickSubmitAccount();
        myAccountPage.titleRegisteredAccount.shouldHave(Condition.visible);
        Assert.assertEquals(myAccountPage.getAccountName(), userAccount.getFirstCustomerName() + " " + userAccount.getLastCustomerName());
        myAccountPage.signoutFromAccount();
    }
}
