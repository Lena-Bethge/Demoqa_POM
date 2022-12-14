package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Base64;

public class ButtonsPage extends BasePage {
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickBtn;


    public ButtonsPage doubleClick() {
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();
        return this;
    }

    @FindBy(id="rightClickBtn")
    WebElement rightClickBtn;

    public ButtonsPage rightClick() {
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickBtn).perform();
        return this;
    }

    @FindBy(xpath = "//button[.='Click Me']")
    WebElement clickMe;

    public ButtonsPage clickMe() {
        Actions actions = new Actions(driver);
        click(clickMe);
        return this;

    }
}
