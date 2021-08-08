package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends MainPage {

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@class='login']")
    public WebElement loginInput;

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement emailCreateInput;

    @FindBy(name = "SubmitCreate")
    public WebElement submitButtonCreate;

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

    @FindBy(xpath = "//div[@id='center_column']/h1")
    public WebElement titleRegisteredAccount;

    /**
     * Method open SingIn page
     */
    public void openRegistrationPage() {
        openUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    /**
     * Method click to SingIn page
     */
    public void clickToSingIn() {
        webElements.clickOnElement(loginInput);
    }

    /**
     * Method input email
     *
     * @param email
     */
    public void inputEmailCreate(String email) {
        webElements.inputText(emailCreateInput, email);
    }

    /**
     * Method submit button
     */
    public void submitButtonCreate() {
        webElements.clickOnElement(submitButtonCreate);
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


    public void selectCity(String text){
        webElements.selectTextInDropDownByText(selectState, text);
    }

    public void selectCountry(String text) {
        webElements.selectTextInDropDownByText(idCountry, text);
    }

//    public void checkTitle(String message, boolean actual, boolean expected) {
//        webElements.checkAC(message, actual, expected);
//    }
//
//    public boolean checkElementPresent() {
//        webElements.isElementPresent(titleRegisteredAccount);
//        return true;
//    }
//
//    public boolean checkTitleTextOnPage(String title) {
//        webElements.checkTitle(title);
//        return true;

}
