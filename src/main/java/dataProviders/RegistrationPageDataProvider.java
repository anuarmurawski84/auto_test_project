package dataProviders;

import com.github.javafaker.Faker;
import model.AccountBuilder;
import org.testng.annotations.DataProvider;

public class RegistrationPageDataProvider {
    public Faker faker = new Faker();

    @DataProvider
    public Object[][] registrationNewUser(){
        return new Object[][]{
                {
                        new AccountBuilder()
                                .withGender("Mr.")
                                .withFirstCustomerName("Edward")
                                .withLastCustomerName("Asan")
                                .withEmail(faker.internet().emailAddress())
                                .withPass("qwerty123")
                                .withDay("28")
                                .withMonth("10")
                                .withYear("1985")
                                .withFirstName("Edward")
                                .withLastName("Asan")
                                .withCompany("Comp123")
                                .withAddress1("street New York, 12")
                                .withAddress2("street New York, 15")
                                .withCity("New York")
                                .withState("New York")
                                .withPostCode("12345")
                                .withCountry("United States")
                                .withPhoneMobile("1234567890")
                                .withAlias("Good")
                                .build()
                }
        };
    }
}
