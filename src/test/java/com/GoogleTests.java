package com;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleTests {

    public WebDriver webDriver;

    @Test
    public void googleTest() {
        File fileChrome = new File("drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileChrome.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://google.com");
        String title = webDriver.getTitle();
        Assert.assertEquals("Google", title);
        webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img")).isDisplayed();
//        webDriver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Selenium" + Keys.ENTER);
        webDriver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Selenium");
        webDriver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).submit();
        String titlePage = webDriver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")).getText();
        Assert.assertEquals("Selenium", titlePage);
        String link = webDriver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div[1]/a/div/cite")).getText();
        Assert.assertEquals("https://www.selenium.dev", link);
        webDriver.quit();
    }

    @Test
    public void seleniumTest() {
        File fileChrome = new File("drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileChrome.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://www.selenium.dev/");
        String h2 = webDriver.findElement(By.xpath("//*[@id=\"banner-blm\"]/h2/strong")).getText();
        Assert.assertEquals("BLACK LIVES MATTER", h2);
        webDriver.findElement(By.xpath("//*[@id=\"navbar\"]/a[3]")).click();
        String h1 = webDriver.findElement(By.xpath("//*[@id=\"the-selenium-browser-automation-project\"]")).getText();
        Assert.assertEquals("The Selenium Browser Automation Project", h1);
        webDriver.findElement(By.id("search-by")).isDisplayed();
        List<WebElement> elements = webDriver.findElements(By.tagName("p"));
        webDriver.findElement(By.className("tabset")).isDisplayed();

        webDriver.quit();
    }
}
