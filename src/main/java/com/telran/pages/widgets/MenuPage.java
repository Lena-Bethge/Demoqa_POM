package com.telran.pages.widgets;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[.='Main Item 2']")
    WebElement mainItem2;

    @FindBy(xpath = "//*[.='SUB SUB LIST »']")
    WebElement subSubList;

    @FindBy(xpath = "//*[.='Sub Sub Item 2']")
    WebElement subSubItem2;

    public MenuPage selectSubMenu() {
        hideAd();
        hideFooter();
        Actions actions = new Actions(driver);
        //mouse hover menu options 'MainItem2'
        actions.moveToElement(mainItem2).perform();
        pause(500);
        //mouse hover menu options 'SUB SUB LIST »'
        actions.moveToElement(subSubList).perform();
        //mouse select 'Sub Sub Item 2'
        actions.moveToElement(subSubItem2).perform();
        return this;
    }
}


//*[.='Main Item 2']
//*[.='Sub Sub Item 2']