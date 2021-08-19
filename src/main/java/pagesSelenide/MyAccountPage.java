package pagesSelenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class MyAccountPage {

    public SelenideElement titleRegisteredAccount = $x("//div[@id='center_column']/h1");
    public SelenideElement accountBtn = $("#header > div.nav > div >div > nav > div:nth-child(1) > a");
    public SelenideElement signoutAccount = $x("//a[@class='logout']");

    @Step("Get account name")
    public String getAccountName(){
        return accountBtn.getText();
    }

    @Step("Get header name {text}")
    public void getHeaderName(){
        titleRegisteredAccount.shouldHave(Condition.visible);
    }

    @Step("Signout account")
    public void signoutFromAccount() {
        signoutAccount.click();
    }
}
