package com.telran.tests.elements;

import com.telran.data.StudentData;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.TextBoxPage;
import com.telran.pages.forms.PracticeFormPage;
import com.telran.tests.TestBase;
import com.telran.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).selectElements();
        new SidePanelPage(driver).selectTextBox();

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "textBoxTest")
    public void textBoxWithDataProviderTest(String fullName, String userEmail, String currentAddress,
                                                     String permanentAddress) {

        new TextBoxPage(driver)
                .enterUserData(fullName,userEmail,currentAddress,permanentAddress)
                .submit();
        Assert.assertTrue(new TextBoxPage(driver).getOutputAssert().contains("Name"));

    }
}
