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
                                .withFirstCustomerName("Ed")
                                .withLastCustomerName("Asan")
                                .withEmail(faker.internet().emailAddress())
                                .withPass("asd")
                                .withDay("28")
                                .withMonth("10")
                                .withYear("1985")
                                .withFirstName("Ed")
                                .withLastName("Asan")
                                .withCompany("Comp123")
                                .withAddress1("street Avenu, 4")
                                .withAddress2("street Avenu, 7")
                                .withCity("Los Angeles")
                                .withState("California")
                                .withPostCode("12345")
                                .withCountry("United States")
                                .withPhoneMobile("1234567890")
                                .withAlias("Good")
                                .build()
                }
        };
    }
}
