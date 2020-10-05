package testCases;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AmazonPayPage;
import pages.HomePage;
import utils.Constants;
import utils.SoftAssert;

public class test1 extends BaseTest {
    HomePage homePage;
    AmazonPayPage amazonPayPage;
    @Test
    public void TC001(){
        SoftAssert softAssert = new SoftAssert();
        homePage = page.getInstance(HomePage.class);
        softAssert.assertEquals(homePage.getTitleOfthePage(), Constants.HOME_PAGE_TITLE, "Mismatch in Home Page Title");
        softAssert.assertEquals(homePage.isAmazonLogoDisplayed(), true, "Amazon Logo is not Displayed");
        amazonPayPage = (AmazonPayPage) homePage.navigateTo(Constants.AMAZONPAY);
        softAssert.assertEquals(utils.getTitleOfThePage(), Constants.AMAZON_PAY_PAGE_TITLE, "Mismatch in Amazon Pay Page Title");
        homePage.doClickOnAmazonLogo();
        softAssert.assertEquals(homePage.getTitleOfthePage(), Constants.HOME_PAGE_TITLE, "Mismatch in Home Page Title");
        softAssert.assertAll();
    }
}
