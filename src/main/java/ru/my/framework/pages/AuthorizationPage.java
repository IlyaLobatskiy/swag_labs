package ru.my.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AuthorizationPage extends BasePage {
    @FindBy(xpath = "//input[@id='user-name']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errore;


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

        return pageManager.getMainPage();
    }

    public String getErroreText(){
        return errore.getText();
    }

}
