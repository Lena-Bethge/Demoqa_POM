package com.telran.tests.bookStore;

import com.telran.data.BookData;
import com.telran.pages.bookstore.BookStorePage;
import com.telran.pages.HomePage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchBookTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectBookStoreApp();
    }

    @Test
    public void searchBookPositiveTest() {
        new BookStorePage(driver).typeInSearchBookInput(BookData.BOOK_NAME);
        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(BookData.BOOK_NAME));
    }


     @Test
     @Parameters({"BOOK_NAME"})
    public void testngSearchBookPositiveTest(String BOOK_NAME) {
        new BookStorePage(driver).typeInSearchBookInput(BOOK_NAME);
        //Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(BOOK_NAME));
    }
}
