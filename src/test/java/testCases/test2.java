package testCases;
import base.BaseTest;
import org.testng.annotations.Test;
import pages.Books;
import pages.HomePage;
import utils.Constants;
import utils.SoftAssert;

public class test2 extends BaseTest {
    HomePage homePage;
    Books book;
    @Test
    public void TC001(){
        SoftAssert softAssert = new SoftAssert();
        homePage = page.getInstance(HomePage.class);
        softAssert.assertEquals(homePage.getTitleOfthePage(), Constants.HOME_PAGE_TITLE, "Mismatch in Home Page Title");
        softAssert.assertEquals(homePage.isAmazonLogoDisplayed(), true, "Amazon Logo is not Displayed");
        homePage.getLinkText().stream().forEachOrdered(x->{
            homePage.clickOn(x);
            homePage.doClickOnAmazonLogo();
            softAssert.assertEquals(homePage.getTitleOfthePage(), Constants.HOME_PAGE_TITLE, "Mismatch in Home Page Title");
        });
        softAssert.assertAll();
    }

    @Test
    public void TC002(){
        SoftAssert softAssert = new SoftAssert();
        homePage = this.page.getInstance(HomePage.class);
        book = (Books)homePage.navigateTo(Constants.BOOKS);
        String titleOfBook = book.getBookList().getText();
        book.SelectBook();
        String actualTitleOfBook = book.getExpectedBookTitle();
        softAssert.assertEquals(titleOfBook, actualTitleOfBook, "Mismatch in book title");
        book.addToCart();
        softAssert.assertAll();
    }
}
