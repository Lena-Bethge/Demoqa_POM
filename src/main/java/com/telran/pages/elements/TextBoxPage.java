package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

}
