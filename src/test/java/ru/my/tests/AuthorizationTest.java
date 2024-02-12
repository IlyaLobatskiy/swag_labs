package ru.my.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.my.tests.base.BaseTest;

public class AuthorizationTest extends BaseTest {

    @Test
    public void authorization(){

        String resault = pageManager.getAuthorizationPage()
                .authorization("standard_user", "secret_sauce").getTextTitleProduct();

        Assertions.assertEquals(
                "Products", resault, "Пользователь не авторизован");
    }

    @Test
    public void emptyName(){

        pageManager.getAuthorizationPage()
                .authorization("", "secret_sauce");
        String res = pageManager.getAuthorizationPage()
                .getErroreText();

        Assertions.assertEquals(
                "Epic sadface: Username is required", res, "Неверный текст ошибки");
    }

    @Test
    public void emptyPassword(){

        pageManager.getAuthorizationPage()
                .authorization("standard_user", "");
        String res = pageManager.getAuthorizationPage()
                .getErroreText();

        Assertions.assertEquals(
                "Epic sadface: Password is required", res, "Неверный текст ошибки");
    }

    @Test
    public void incorrectUser(){

        pageManager.getAuthorizationPage().authorization("asd", "asd");
        String resault = pageManager.getAuthorizationPage().getErroreText();

        Assertions.assertEquals(
                "Epic sadface: Username and password do not match any user in this service",
                resault, "Неверный текст ошибки");
    }

}
