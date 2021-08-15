package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends MainPage{
    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@id='center_column']/h1")
    public WebElement titleRegisteredAccount;

    @FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(1) > a")
    public WebElement accountBtn;

    public String getAccountName(){
        return accountBtn.getText();
    }

    public void getHeaderName(String text){
        webElements.isElementPresent(text);
    }

}
