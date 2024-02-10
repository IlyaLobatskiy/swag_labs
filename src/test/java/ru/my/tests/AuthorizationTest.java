package ru.my.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.my.framework.pages.AuthorizationPage;
import ru.my.framework.pages.MainPage;
import ru.my.tests.base.BaseTest;

public class AuthorizationTest extends BaseTest {


    @Test
    public void authorization(){
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        MainPage mainPage = authorizationPage.authorization("standard_user", "secret_sauce");

        Assert.assertEquals("Пользователь не авторизован", "Products", mainPage.getTextTitleProduct());
    }

    @Test
    public void emptyName(){
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.authorization("", "secret_sauce");
        String res = authorizationPage.getErroreText();

        Assert.assertEquals("Неверный текст ошибки", "Epic sadface: Username is required", res);
    }

    @Test
    public void emptyPassword(){
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.authorization("standard_user", "");
        String res = authorizationPage.getErroreText();

        Assert.assertEquals("Неверный текст ошибки", "Epic sadface: Password is required", res);
    }

    @Test
    public void incorrectUser(){
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.authorization("asd", "asd");
        String res = authorizationPage.getErroreText();

        Assert.assertEquals("Неверный текст ошибки", "Epic sadface: Username and password do not match any user in this service", res);
    }

}
