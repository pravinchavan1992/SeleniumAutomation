package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class Computers extends BasePage {
    private WebDriver driver;
    public Computers(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
