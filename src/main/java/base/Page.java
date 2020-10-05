package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.ElementUtils;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;


public abstract class Page {
    WebDriver driver;
    WebDriverWait wait;
    ElementUtils utils;

    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        this.utils = new ElementUtils(this.driver);
    }
    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass){
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
    public abstract String getTitleOfthePage();
    public abstract WebElement getWebElement(By locator);
    public abstract void enterText(By locator, String Text);
    public abstract void clickOn(By locator);
    public abstract String getText(By locator);
    public abstract void clearField(By locator);
    public abstract boolean isSelected (By locator);
    public abstract boolean isDisPlayed (By locator);
    public abstract boolean isEnabled (By locator);
    public abstract void selectDropDownValueByVisibleText (By locator, String Text);
    public abstract void selectDropDownValueByText (By locator, String Text);
    public abstract void selectDropDownValueByIndex (By locator, int i);
    public abstract List<String> getAllDropDownValues (By locator);
    public abstract List<String> getAllSelectedDropDownValues(By locator);
    public abstract WebElement waitForElementWithFluentWait(By locator, int timeOut, int interval);
    public abstract WebElement waitForElement(By locator);
    public abstract void waitForPageLoaded();
    public abstract List<String> getLinkListText(By locator);
}
