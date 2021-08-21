package SelenideTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import dataProviders.RegistrationPageDataProvider;
import model.Account;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ScreenShooter.class, TextReport.class})
@Report
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

    @Test
    public void testFindProduct(){
        Selenide.open(Configuration.baseUrl);
        mainPage.getProduct();
        mainPage.clickToProduct("Blouse");

    }
}
