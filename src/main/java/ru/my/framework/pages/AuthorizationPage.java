package ru.my.framework.pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;
import java.util.Random;


public class AuthorizationPage extends BasePage {
    WebDriver driver;
    @FindBy(xpath = "//input[@id='user-name']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errore;


    public AuthorizationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void inputUserName(String name) {
        userName.sendKeys(name);
    }

    public void inputPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public MainPage authorization(String name, String pass) {

        inputUserName(name);
        inputPassword(pass);
        clickLoginButton();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        return new MainPage(driver);
    }

    public String getErroreText(){
        return errore.getText();
    }

}
