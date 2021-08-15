package pages;

import model.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends MainPage {

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(name = "SubmitCreate")
    public WebElement submitButtonCreate;

    @FindBy(xpath = "//form[@id='account-creation_form']/div[@class='account_creation']")
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

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement LastNameInput;

    @FindBy(xpath = "//div[@class='account_creation']//p[4]//input[@type='text']")
    public WebElement streetInput;

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
    public void submitButtonCreate() {
        webElements.clickOnElement(submitButtonCreate);
    }

    public void inputFromAccount() {
        webElements.clickOnElement(fromAccount);
    }

    public void selectGender(String gender){
        if (gender.equals("Mr.")){
            webElements.clickRadioButton(genderMr, gender);
        } else {
            webElements.clickRadioButton(genderMs, gender);
        }
    }

    public void inputCustomerFN(String firstName) {
        webElements.inputText(customerFirstName, firstName);
    }

    public void inputCustomerLN(String lastName) {
        webElements.inputText(customerLastName, lastName);
    }

    public void inputEmail(String email) {
        webElements.inputText(emailInput, email);
    }

    public void inputPassword(String password) {
        webElements.inputText(passwordInput, password);
    }

    public void inputFirstName(String firstName) {
        webElements.inputText(firstNameInput, firstName);
    }

    public void inputLastName(String lastName) {
        webElements.inputText(LastNameInput, lastName);
    }

    public void inputStreet(String street) {
        webElements.inputText(streetInput, street);
    }

    public void inputCity(String city) {
        webElements.inputText(cityInput, city);
    }

    public void inputPostCode(String postCode) {
        webElements.inputText(postCodeInput, postCode);
    }

    public void inputMobilePhone(String phone) {
        webElements.inputText(phoneMobileInput, phone);
    }

    public void inputAlias(String alias) {
        webElements.inputText(aliasInput, alias);
    }

    public void clickSubmitAccount() {
        webElements.clickOnElement(submitAccount);
    }


    public void selectCity(String text) {
        webElements.selectTextInDropDownByText(selectState, text);
    }

    public void selectCountry(String text) {
        webElements.selectTextInDropDownByText(idCountry, text);
    }

    public void registrationUser(Account account){
        selectGender(account.getGender());
        inputCustomerFN(account.getFirstCustomerName());
    }
}