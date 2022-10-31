package com.telran.pages;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void click(WebElement element) {
        element.click();

    }

    public void type(WebElement element, String text) {
        if (text != null) {
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
    public void typeWithJsExecutor(WebElement element, String text,int x, int y) {
        if (text != null) {
           clickWithJSExecutor(element,x,y);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void clickWithAction(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        element.click();
    }

    public void clickWithJSExecutor(WebElement element,int x,int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        element.click();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void takeScreenshots() {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(" screenshots/screen" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        screenshot.getAbsolutePath();
    }

    //скрыть рекламу
    public void hideAd() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("document.getElementById('adplus-anchor').style.display='none'");
    }
    //скрыть футер
    public void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("document.querySelector('footer').style.display='none'");


    }

    public void closeBanner() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('close-fixedban').style.display='none'");
    }

    public void clickWithRectangle(WebElement element,int i,int j) {

        Rectangle rectangle = element.getRect();

        int offSetX = rectangle.getWidth()/i;
        int offSetY = rectangle.getHeight()/j;

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.moveByOffset(-offSetX,-offSetY).click().perform();
    }

    public void takeScreenshotListener(String pathToFile) {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(pathToFile);
        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
