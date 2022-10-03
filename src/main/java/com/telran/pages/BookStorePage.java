package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class BookStorePage extends BasePage{
    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login")
    WebElement loginButton;

    public LoginPage clickOnButton() {
        click(loginButton);
        return new LoginPage(driver);
    }
    @FindBy(id = "searchBox")
    WebElement searchInput;

    public BookStorePage typeInSearchBookInput(String bookName) {
        type(searchInput,bookName);
        return this;

    }

    @FindBy(xpath = "//*[text()='Git Pocket Guide']")
    WebElement nameOfBook;

    public String takeNameOfBook() {
        return nameOfBook.getText();

    }
}