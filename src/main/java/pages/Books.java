package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Books extends BasePage {
    private WebDriver driver;

    private By firstBook = By.xpath("//div[contains(@id,'carousel_')][1]//li[1]/div");
    private By productTitle = By.xpath("//span[@id='productTitle']");
    private By addToCartButton = By.cssSelector("input#add-to-cart-button");
    private By bookTitle = By.cssSelector("#anonCarousel1 .a-truncate-cut");
    public Books(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void selectFirstBook(){
        this.clickOn(this.firstBook);
        this.waitForPageLoaded();
    }
    public WebElement getBookList(){ return this.getLinkList(this.bookTitle).get(0); }
    public List<String> getListOfBooks(){ return this.getLinkListText(this.bookTitle); }
    public void SelectBook(){
        this.clickOn(getBookList());
        this.waitForPageLoaded();
    }
    public String getExpectedBookTitle(){ return this.getWebElement(this.productTitle).getText();}
    public void addToCart(){
        this.clickOn(this.addToCartButton);
        this.waitForPageLoaded();
    }
}
