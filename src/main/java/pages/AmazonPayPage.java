package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class AmazonPayPage extends BasePage {
    private WebDriver driver;
    public AmazonPayPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
