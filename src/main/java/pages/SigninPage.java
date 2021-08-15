package pages;

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


}
