package pages;

import io.qameta.allure.Step;
import model.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationPage extends MainPage {

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(name = "SubmitCreate")
    public WebElement submitButtonCreate;

    @FindBy(xpath = "//form[@id='account-creation_form']/div[@class='account_creation']/div[1]/div[1]")
    public WebElement fromAccount;

    @FindBy(id = "id_gender1")
    public WebElement genderMr;

    @FindBy(id = "id_gender2")
    public WebElement genderMs;

    @FindBy(id = "customer_firstname")
    public WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    public WebElement customerLastName;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "passwd")
    public WebElement passwordInput;

    @FindBy(id = "days")
    public WebElement daysDropdown;

    @FindBy(id = "months")
    public WebElement monthsDropdown;

    @FindBy(id = "years")
    public WebElement yearsDropdown;

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement LastNameInput;

    @FindBy(id = "company")
    public WebElement companyName;

    @FindBy(xpath = "//div[@class='account_creation']//p[4]//input[@type='text']")
    public WebElement addressByDefault;

    @FindBy(xpath = "//div[@class='account_creation']//p[5]//input[@type='text']")
    public WebElement addressLine;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement cityInput;

    @FindBy(id = "id_state")
    public WebElement selectState;

    @FindBy(css = "#postcode")
    public WebElement postCodeInput;

    @FindBy(id = "id_country")
    public WebElement idCountry;

    @FindBy(id = "phone_mobile")
    public WebElement phoneMobileInput;

    @FindBy(id = "alias")
    public WebElement aliasInput;

    @FindBy(xpath = "//button[@name='submitAccount']")
    public WebElement submitAccount;

    /**
     * Method open SingIn page
     */
    public void openRegistrationPage() {
            openUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    /**
     * Method submit button
     */
    @Step("Submit button")
    public void submitButtonCreate() {
        webElements.clickOnElement(submitButtonCreate);
    }

    @Step("Input from account")
    public void inputFromAccount() {
        webElements.clickOnElement(fromAccount);
    }

    @Step("Select gender {gender}")
    public void selectGender(String gender){
        if (gender.equals("Mr.")){
            webElements.clickRadioButton(genderMr, gender);
        } else {
            webElements.clickRadioButton(genderMs, gender);
        }
    }

    @Step("Input customer first name {firstName}")
    public void inputCustomerFN(String firstName) {
        webElements.inputText(customerFirstName, firstName);
    }

    @Step("Input customer last name {lastName}")
    public void inputCustomerLN(String lastName) {
        webElements.inputText(customerLastName, lastName);
    }

    @Step("Input email {email}")
    public void inputEmail(String email) {
        webElements.inputText(emailInput, email);
    }

    @Step("Input password {password}")
    public void inputPassword(String password) {
        webElements.inputText(passwordInput, password);
    }

    @Step("Select birthday {day}")
    public void selectBirthDay(String day){
        webElements.selectValueInDropDown(daysDropdown, day);
    }

    @Step("Select birth month {month}")
    public void selectBirthMonth(String month){
        webElements.selectValueInDropDown(monthsDropdown, month);
    }

    @Step("Select birth {year}")
    public void selectBirthYear(String year){
        webElements.selectValueInDropDown(yearsDropdown, year);
    }

    @Step("Input First Name {firstName}")
    public void inputFirstName(String firstName) {
        webElements.inputText(firstNameInput, firstName);
    }

    @Step("Input Last Name {lastName}")
    public void inputLastName(String lastName) {
        webElements.inputText(LastNameInput, lastName);
    }

    @Step("Input company {company}")
    public void inputCompany(String company) {
        webElements.inputText(companyName, company);
    }

    @Step("Input default address {address}")
    public void inputAddressByDefault(String address) {
        webElements.inputText(addressByDefault, address);
    }

    @Step("Input address line {address}")
    public void inputAddressLine(String address) {
        webElements.inputText(addressLine, address);
    }

    @Step("Input city {city}")
    public void inputCity(String city) {
        webElements.inputText(cityInput, city);
    }

    @Step("Input postcode {postCode}")
    public void inputPostCode(String postCode) {
        webElements.inputText(postCodeInput, postCode);
    }

    @Step("Input mobile phone {phone}")
    public void inputMobilePhone(String phone) {
        webElements.inputText(phoneMobileInput, phone);
    }

    @Step("Input alias {alias}")
    public void inputAlias(String alias) {
        webElements.inputText(aliasInput, alias);
    }

    @Step("Submit account")
    public void clickSubmitAccount() {
        webElements.clickOnElement(submitAccount);
    }

    @Step("Select state {text}")
    public void selectState(String text) {
        webElements.selectTextInDropDown(selectState, text);
    }

    @Step("Select country {text}")
    public void selectCountry(String text) {
        webElements.selectTextInDropDown(idCountry, text);
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