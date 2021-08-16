package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigninPage extends MainPage {

    public SigninPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@class='login']")
    public WebElement loginInput;

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement emailCreateInput;


    /**
     * Method click to SignIn page
     */
    @Step("Click to Signin page")
    public void clickToSingIn() {
        webElements.clickOnElement(loginInput);
    }

    /**
     * Method input email
     *
     * @param email
     */
    @Step("Input email {email}")
    public void inputEmailCreate(String email) {
        webElements.inputText(emailCreateInput, email);
    }


}
