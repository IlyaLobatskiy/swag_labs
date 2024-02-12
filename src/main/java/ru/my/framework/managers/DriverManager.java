package ru.my.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.my.framework.utils.ConstansProp;

public class DriverManager {
    private WebDriver driver = null;

    private static DriverManager INSTANCE = null;

    private final TestPropManager testPropManager = TestPropManager.getTestPropManager();

    private DriverManager() {
    }

    public static DriverManager getDriverManager() {
        if (INSTANCE == null){
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver(){
        if (driver == null){
            System.setProperty(String.format("webdriver.%s.driver", testPropManager.getProperty(ConstansProp.TYPE_BROWSE)),
                    testPropManager.getProperty(ConstansProp.PATH_DRIVER));
            driver = new ChromeDriver();
        }

        return driver;
    }

    public void quitDriver(){
        driver.quit();
    }

}
