package com.telran.pages;

import com.telran.pages.bookstore.BookStorePage;
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

    @FindBy(xpath = "//*[@class='category-cards']/*[3]")
    WebElement alertFrameWindows;

    public SidePanelPage selectAlertsFrameWindows() {
        clickWithJSExecutor(alertFrameWindows,0,300);
        return new SidePanelPage(driver);
    }

    @FindBy(xpath = "//*[@class='category-cards']/*[1]")
    WebElement elements;

    public SidePanelPage selectElements() {
        clickWithJSExecutor(elements,0,300);
        return new SidePanelPage(driver);
    }


    @FindBy(xpath = "//*[@class='category-cards']/*[4]")
    WebElement widgets;

    public SidePanelPage selectWidgets() {
        clickWithJSExecutor(widgets,0,300);
        return new SidePanelPage(driver);
    }

    @FindBy(xpath = "//*[@class='category-cards']/*[2]")
    WebElement forms;

    public SidePanelPage selectForms() {
        clickWithJSExecutor(forms,0,300);
        return new SidePanelPage(driver);
    }

    @FindBy(xpath = "//*[.='Interactions']")
    WebElement interactions;

    public SidePanelPage selectInteractions() {
        clickWithJSExecutor(interactions,0,300);
        return new SidePanelPage(driver);
    }
}
