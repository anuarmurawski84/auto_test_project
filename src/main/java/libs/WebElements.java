package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.is;

public class WebElements {

    WebDriver webDriver;
    Logger logger;

    public WebElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }


    /**
     * Method input text
     *
     * @param element
     * @param text
     */
    public void inputText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted");
        } catch (Exception e) {
            logger.error("Can't work with element " + element);
            Assert.fail("Can't work with element " + element);
        }
    }

    /**
     * Method click element button
     *
     * @param element
     */
    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked " + element);
        } catch (Exception e) {
            logger.error("Can't work with element " + element);
            Assert.fail("Can't work with element " + element);
        }
    }

    /**
     * Method is element present by text
     *
     * @param text
     * @return false
     */
    public boolean isElementPresent(String text) {
        try {
            return webDriver.findElement(By.xpath(text)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void checkTitle(String expectedTitle) {
        try {
            Assert.assertThat("Title not matched", webDriver.getTitle(), is(expectedTitle));
        } catch (Exception e) {
            logger.error("Can't find title " + expectedTitle);
            Assert.fail("Can't find title " + expectedTitle);
        }
    }

    /**
     * Method check text in element
     *
     * @param xpath
     * @param text
     */
    public void checkTextInElement(String xpath, String text) {
        try {
            String textFromElement = webDriver.findElement(By.xpath(xpath)).getText();
            Assert.assertThat("Text in element not matched", textFromElement, is(text));
        } catch (Exception e) {
            logger.error("Can't check text in element " + text);
            Assert.fail("Can't check text in element " + text);
        }
    }

    /**
     * Method check select in dropdown
     *
     * @param dropdown
     * @param text
     */
    public void selectTextInDropDownByText(WebElement dropdown, String text) {
        try {
            Select optionsFromDropDown = new Select(dropdown);
            optionsFromDropDown.selectByVisibleText(text);
//            optionsFromDropDown.selectByIndex(index);
            logger.info("Was selected dropdown by text: " + text);
        } catch (Exception e) {
            logger.error("Can't work with dropdown");
            Assert.fail("Can't work with dropdown");
        }
    }
}


//    public void checkAC(String message, boolean actualRes, boolean expectedRes) {
//        Assert.assertThat(message, actualRes, is(expectedRes));
//    }


