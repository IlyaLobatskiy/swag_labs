package ru.my.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(xpath = "//div[@id='header_container']//span[@class='title']")
    WebElement titleProducts;

    public String getTextTitleProduct(){
        return titleProducts.getText();
    }
}
