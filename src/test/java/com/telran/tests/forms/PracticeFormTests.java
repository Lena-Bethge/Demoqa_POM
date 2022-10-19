package com.telran.tests.forms;

import com.telran.data.StudentData;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.forms.PracticeFormPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).selectForms();
        new SidePanelPage(driver).selectPracticeForm();
    }

   @DataProvider
    public Iterator<Object[]> addNewStudent() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Jack","Joy","joy@dmail.com","Male","9876543210","1 May 1987","Leipzig","NCR","Delhi"});
        list.add(new Object[]{"Jack","Joy","joy+1@dmail.com","Male","1234567890","1 May 1987","Leipzig","NCR","Delhi"});
        list.add(new Object[]{"Jack","Joy","joy+2@dmail.com","Male","9988776655","1 Juli 1999","Leipzig","NCR","Delhi"});

        return list.iterator();
    }

    @Test(dataProvider = "addNewStudent")
    public void createNewStudent() {
        new PracticeFormPage(driver).hideIframes().enterPersonalData(StudentData.FIRST_NAME,StudentData.LAST_NAME,StudentData.EMAIL,
                StudentData.TEL_NUM,StudentData.ADDRESS);

        new PracticeFormPage(driver).selectGender(StudentData.GENDER)

                .chooseDate("May","1987", "1")
                //.typeOfDate(StudentData.DATE)
                .addSubject(StudentData.SUBJECTS)
                .chooseHobby(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO_PATH)
                .enterState(StudentData.STATE)
                .enterCity(StudentData.CITY).submit();
        Assert.assertTrue(new PracticeFormPage(driver).getModelTittle().contains("Thanks for submitting the form"));
        new PracticeFormPage(driver).closeModalDialog();
    }
}
