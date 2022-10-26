package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class LinksDemo extends BasePage {

    public LinksDemo(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> links1;

    public LinksDemo checkAllLinks1() {
        System.out.println("Total links on the Webpage: " + links1.size());
        String url = "";
        Iterator<WebElement> iterator = links1.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }

    public LinksDemo checkBrokenLinks1() {
        for (int i = 0; i < links1.size(); i++) {
            WebElement element = links1.get(i);
            String url = element.getAttribute("href");
            verifyLinks1(url);
        }
        return this;

    }

    private void verifyLinks1(String link1Url) {
        try {
            URL url = new URL(link1Url);
            //create url connection and get status code >=400(это битая ссылка)
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect(); //соединение
            if(httpURLConnection.getResponseCode() >= 400) {
                System.out.println(link1Url + " - " + httpURLConnection.getResponseMessage() + " is a broken link");
            } else {
                System.out.println(link1Url + " - " + httpURLConnection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(link1Url + " - " + e.getMessage() + " is a broken link");

        }
    }
}
