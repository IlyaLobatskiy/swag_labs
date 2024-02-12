package ru.my.framework.managers;

import ru.my.framework.pages.AuthorizationPage;
import ru.my.framework.pages.MainPage;

public class PageManager {
    private static PageManager INSTANCE = null;
    private AuthorizationPage authorizationPage = null;
    private MainPage mainPage = null;

    private PageManager(){

    }

    public static PageManager getPageManager() {
        if(INSTANCE == null){
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    public AuthorizationPage getAuthorizationPage() {
        if(authorizationPage == null){
            authorizationPage = new AuthorizationPage();
        }

        return authorizationPage;
    }

    public MainPage getMainPage() {
        if(mainPage == null){
            mainPage = new MainPage();
        }
        return mainPage;
    }


}
