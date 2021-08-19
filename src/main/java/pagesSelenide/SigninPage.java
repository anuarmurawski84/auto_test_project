package pagesSelenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;

public class SigninPage {
    public SelenideElement loginInput = $x("//a[@class='login']");
    public SelenideElement emailCreateInput = $x("//input[@id='email_create']");



    /**
     * Method click to SignIn page
     */
    @Step("Click to Signin page")
    public void clickToSignIn() {
        loginInput.click();
    }

    /**
     * Method input email
     *
     * @param email
     */
    @Step("Input email {email}")
    public void inputEmailCreate(String email) {
        emailCreateInput.setValue(email);
    }


}
