package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement fullName;

    @FindBy(id = "userEmail")
    WebElement typeUserEmail;

    @FindBy(id = "currentAddress")
    WebElement typeCurrentAddress;

    @FindBy(id = "permanentAddress")
    WebElement typePermanentAddress;

    public TextBoxPage enterUserData(String userName, String userEmail, String currentAddress, String permanentAddress) {
        hideAd();
        type(fullName, userName);
        type(typeUserEmail, userEmail);
        type(typeCurrentAddress,currentAddress);
        typeWithJsExecutor(typePermanentAddress, permanentAddress,0,300);

        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public TextBoxPage submit() {
        click(submit);
        return this;
    }

    @FindBy(id = "output")
    WebElement output;

    public String getOutputAssert() {
        return output.getText();
    }

    public TextBoxPage keyBoardEvent() {
        //enter username
        type(fullName,"Lusy Lee");
        //enter email
        type(typeUserEmail,"lusy@gmail.com");
        //enter current address
        typeWithJsExecutor(typeCurrentAddress,"Bahnhofstr.20, 10234 Leipzig",0,200);
        //create object of the Actiions class
        Actions actions = new Actions(driver);
        //pause(500);
        //select current Address
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        //copy current Address
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        //press the tab Key to switch focus to permanent address
        actions.sendKeys(Keys.TAB).perform();
        //past the current address in the permanent address field
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        System.out.println(typeCurrentAddress.getAttribute("value"));
        System.out.println(typePermanentAddress.getAttribute("value"));
        return this;
    }

    public String getAttribute() {
        return typePermanentAddress.getAttribute("value");
    }
}
