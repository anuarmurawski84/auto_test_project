package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
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
    public WebElement selectStateByIndex;

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
        try {
            loginInput.click();
            logger.info("Click to SingIn page");
        } catch (Exception e) {
            logger.error("Can't click to SingIn");
            Assert.fail("Can't click to SingIn");
        }
    }

    /**
     * Method input email
     * @param email
     * */
    public void inputEmailCreate(String email) {
        try {
            emailCreateInput.sendKeys(email);
            logger.info("Input email " + email);
        } catch (Exception e) {
            logger.error("Can't input email " + email);
            Assert.fail("Can't input email " + email);
        }
    }

    /**
     * Method submit button
     * */
    public void submitButtonCreate() {
        try {
            submitButtonCreate.click();
            logger.info("Click submit button");
        } catch (Exception e) {
            logger.error("Can't submit button");
            Assert.fail("Can't submit button");
        }
    }

    /**
     * Method select city by index
     * @param index
     * */
    public void selectCity(int index) {
        try {
            Select select = new Select(webDriver.findElement(By.id("id_state")));
            select.selectByIndex(index);
            logger.info("Find select city by 32");
        } catch (Exception e) {
            logger.error("Can't find select city by 32");
        }
    }

    /**
     * Method
     * */
    public void selectCountry(String country) {
        try {
            Select select = new Select(webDriver.findElement(By.id("id_country")));
            select.selectByVisibleText(country);
            logger.info("Find select country " + country);
        } catch (Exception e) {
            logger.error("Can't find select country " + country);
        }
    }

    /**
     * Method
     * @param
     * */

    /**
     * Method
     * @param
     * */
}
