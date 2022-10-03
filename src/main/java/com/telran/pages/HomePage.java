package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Book Store Application']")
    WebElement bookStoreAppTitle;

    public BookStorePage selectBookStoreApp() {
        clickWithJSExecutor(bookStoreAppTitle,0,700);
        return new BookStorePage(driver);
    }



}
