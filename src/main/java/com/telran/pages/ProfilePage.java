package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage verifyUserName() {
        return this;
    }
    //id=userName-value
    @FindBy(id = "userName-value")
    WebElement userNameValue;

    //xpath //button[contains(text(),'Log out')]
    @FindBy(xpath = "//*[contains(text(),'Log out')]")
    WebElement logout;

    public ProfilePage verifyUserName(String userName) {
        if (userNameValue.getText().equalsIgnoreCase(userName)) {
            System.out.println("Correct user name: " + userNameValue.getText());
        } else {
            System.out.println("Incorrect user name: " + userNameValue.getText());
        }
        return this;
    }

    public LoginPage logOut() {
        click(logout);
        return new LoginPage(driver);
    }

    @FindBy(id = "delete-record-undefined")
    List<WebElement> trashList;

    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;

    public ProfilePage deleteBook() {
        trashList.get(0).click();
        pause(500);
        click(okButton);
        pause(500);
        acceptAlert();
        return this;
    }
}

//[id='closeSmallModal-ok']
