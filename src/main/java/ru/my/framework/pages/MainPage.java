package ru.my.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    WebDriver driver;
    @FindBy(xpath = "//div[@id='header_container']//span[@class='title']")
    WebElement titleProducts;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getTextTitleProduct(){
        return titleProducts.getText();
    }
}
