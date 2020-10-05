package pages;

import base.BasePage;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Constants;

import java.util.List;

public class HomePage extends BasePage {
    private WebDriver driver;
    private By amazonLogo = By.className("nav-logo-link");
    private By getAmazonLink(String LinkName){ return By.xpath("//*[@id='nav-xshop']//a[normalize-space(text()) =\""+LinkName+"\"]"); }
    private By getAmazonLink = By.xpath("//*[@id='nav-xshop']//a");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isAmazonLogoDisplayed(){ return this.isDisPlayed(this.amazonLogo); }

    public Page navigateTo(String linkName){
        this.clickOn(this.getAmazonLink(linkName));
        this.waitForPageLoaded();
        Page page = null;
        switch (linkName) {
            case Constants.AMAZONPAY:
                page = getInstance(AmazonPayPage.class);
                break;
            case Constants.BOOKS:
                page = getInstance(Books.class);
                break;
            case Constants.COMPUTERS:
                page = getInstance(Computers.class);
                break;
        }
        return page;
    }

    public void clickOn(String linkName){
        this.clickOn(this.getAmazonLink(linkName));
        this.waitForPageLoaded();
    }

    public HomePage doClickOnAmazonLogo(){
        this.clickOn(this.amazonLogo);
        this.waitForPageLoaded();
        return getInstance(HomePage.class);
    }

    public List<String> getLinkText(){ return this.getLinkListText(this.getAmazonLink); }
}
