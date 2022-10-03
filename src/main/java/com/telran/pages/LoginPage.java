package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[placeholder='UserName']" )
    WebElement userName;

    @FindBy(css = "[placeholder='Password']")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginBtn;


    public ProfilePage login(String name,String pwd) {
        typeWithJsExecutor(userName,name,0,300);
        type(password,pwd);
        click(loginBtn);
        return new ProfilePage(driver);

    }
    public LoginPage loginNegative(String name,String pwd) {
        type(userName,name);
        type(password,pwd);
        click(loginBtn);
        return this;
    }
}
//cssSelector[placeholder='UserName']
//cssSelector[placeholder='Password']
//[id='login']