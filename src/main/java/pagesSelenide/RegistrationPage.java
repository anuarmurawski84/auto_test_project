package pagesSelenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import model.Account;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {
    public SelenideElement
            submitButtonCreate = $(By.name("SubmitCreate")),
            fromAccount = $x("//form[@id='account-creation_form']/div[@class='account_creation']/div[1]/div[1]"),
            genderMr = $(By.id("id_gender1")),
            genderMs = $(By.id("id_gender2")),
            customerFirstName = $(By.id("customer_firstname")),
            customerLastName = $(By.id("customer_lastname")),
            emailInput = $(By.id("email")),
            passwordInput = $(By.id("passwd")),
            daysDropdown = $(By.id("days")),
            monthsDropdown = $(By.id("months")),
            yearsDropdown = $(By.id("years")),
            firstNameInput = $x("//input[@id='firstname']"),
            LastNameInput = $x("//input[@id='lastname']"),
            companyName = $(By.id("company")),
            addressByDefault = $x("//div[@class='account_creation']//p[4]//input[@type='text']"),
            addressLine = $x("//div[@class='account_creation']//p[5]//input[@type='text']"),
            cityInput = $x("//input[@id='city']"),
            selectState = $(By.id("id_state")),
            postCodeInput = $("#postcode"),
            idCountry = $(By.id("id_country")),
            phoneMobileInput = $(By.id("phone_mobile")),
            aliasInput = $(By.id("alias")),
            submitAccount = $x("//button[@name='submitAccount']");

    /**
     * Method submit button
     */
    @Step("Submit button")
    public void submitButtonCreate() {
        submitButtonCreate.click();
    }

    @Step("Input from account")
    public void inputFromAccount() {
        fromAccount.click();
    }

    @Step("Select gender {gender}")
    public void selectGender(String gender){
        if (gender.equals("1")){
            genderMr.selectRadio(gender);
        } else {
            genderMs.selectRadio(gender);
        }
    }

    @Step("Input customer first name {firstName}")
    public void inputCustomerFN(String firstName) {
        customerFirstName.setValue(firstName);
    }

    @Step("Input customer last name {lastName}")
    public void inputCustomerLN(String lastName) {
        customerLastName.setValue(lastName);
    }

    @Step("Input email {email}")
    public void inputEmail(String email) {
        emailInput.setValue(email);
    }

    @Step("Input password {password}")
    public void inputPassword(String password) {
        passwordInput.setValue(password);
    }

    @Step("Select birthday {day}")
    public void selectBirthDay(String day){
        daysDropdown.selectOptionByValue(day);
    }

    @Step("Select birth month {month}")
    public void selectBirthMonth(String month){
        monthsDropdown.selectOptionByValue(month);
    }

    @Step("Select birth {year}")
    public void selectBirthYear(String year){
        yearsDropdown.selectOptionByValue(year);
    }

    @Step("Input First Name {firstName}")
    public void inputFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }

    @Step("Input Last Name {lastName}")
    public void inputLastName(String lastName) {
        LastNameInput.setValue(lastName);
    }

    @Step("Input company {company}")
    public void inputCompany(String company) {
        companyName.setValue(company);
    }

    @Step("Input default address {address}")
    public void inputAddressByDefault(String address) {
        addressByDefault.setValue(address);
    }

    @Step("Input address line {address}")
    public void inputAddressLine(String address) {
        addressLine.setValue(address);
    }

    @Step("Input city {city}")
    public void inputCity(String city) {
        cityInput.setValue(city);
    }

    @Step("Input postcode {postCode}")
    public void inputPostCode(String postCode) {
        postCodeInput.setValue(postCode);
    }

    @Step("Input mobile phone {phone}")
    public void inputMobilePhone(String phone) {
        phoneMobileInput.setValue(phone);
    }

    @Step("Input alias {alias}")
    public void inputAlias(String alias) {
        aliasInput.setValue(alias);
    }

    @Step("Submit account")
    public void clickSubmitAccount() {
        submitAccount.click();
    }

    @Step("Select state {text}")
    public void selectState(String text) {
        selectState.selectOptionContainingText(text);
    }

    @Step("Select country {text}")
    public void selectCountry(String text) {
        idCountry.selectOptionContainingText(text);
    }

    @Step("Is displayed text by xpath {text}")
    public void isDisplayedTextByXpath(String text){
        $(By.xpath(text)).shouldHave(Condition.visible);
    }

    public void registrationUser(Account account){
        selectGender(account.getGender());
        inputCustomerFN(account.getFirstCustomerName());
        inputCustomerLN(account.getLastCustomerName());
        inputEmail(account.getEmail());
        inputPassword(account.getPass());
        selectBirthDay(account.getDay());
        selectBirthMonth(account.getMonth());
        selectBirthYear(account.getYear());
        inputFirstName(account.getFirstName());
        inputLastName(account.getLastName());
        inputCompany(account.getCompany());
        inputAddressByDefault(account.getAddress1());
        inputAddressLine(account.getAddress2());
        inputCity(account.getCity());
        selectState(account.getState());
        inputPostCode(account.getPostCode());
        selectCountry(account.getCountry());
        inputMobilePhone(account.getPhoneMobile());
        inputAlias(account.getAlias());
    }
}