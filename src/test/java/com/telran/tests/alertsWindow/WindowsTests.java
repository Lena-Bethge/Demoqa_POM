package com.telran.tests.alertsWindow;

import com.telran.pages.alertsWindows.BrowserWindowsPage;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectAlertsFrameWindows();
        new SidePanelPage(driver).selectBrowserWindows();
    }

    @Test
    public void newTabTest() {
        new BrowserWindowsPage(driver).clickOnNewTabButton();
        Assert.assertTrue(new BrowserWindowsPage(driver).getTextFromNewTab().contains("sample"));

    }

    @Test
    public void newWindowTest() {
        new BrowserWindowsPage(driver).clickOnNewWindowButton();
        Assert.assertTrue(new BrowserWindowsPage(driver).getTextFromNewWindow().contains("This is a sample page"));
    }

//    @Test
//    public void newWindowMessage() {
//        new BrowserWindowsPage(driver).clickOnNewWindowMessage();
//        Assert.assertTrue(new BrowserWindowsPage(driver).getTextFromNewWindowMessage().contains("Knowledge"));
//    }
}
