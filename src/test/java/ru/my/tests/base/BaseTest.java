package ru.my.tests.base;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void installDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofMillis(10), Duration.ofSeconds(10));

        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);
    }


    @After
    public void quitDriver() {
        driver.quit();
    }

}
