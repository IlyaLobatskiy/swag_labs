package ru.my.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.my.framework.managers.DriverManager;
import ru.my.framework.managers.PageManager;

import java.time.Duration;

public class BasePage {

    protected DriverManager driverManager = DriverManager.getDriverManager();
    protected PageManager pageManager = PageManager.getPageManager();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofMillis(10), Duration.ofSeconds(10));

    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }


    /**
     * Скрол доэлемента на JS коде
     *
     * @param element - элемент до которого надо проскролить
     */

    protected void scrollToElementJs(WebElement element) {
        JavascriptExecutor javascriptException = (JavascriptExecutor) driverManager.getDriver();
        javascriptException.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    /**
     * Явное ожидание того, что элемент станет кликабельным
     *
     * @param element - ожидаемый элимент
     */

    protected WebElement waitUtilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Явное ожидание того, что элемент станет видимым
     *
     * @param locator - локатор до вэб-элемента который мы ожидаем увидеть на странице
     */

    protected void waitUtilElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Явное ожидание того, что элемент станет видимым
     *
     * @param element - локатор до вэб-элемента который мы ожидаем увидеть на странице
     */

    protected void waitUtilElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
