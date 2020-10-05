package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ElementUtils {
    WebDriver driver;
    WebDriverWait wait;

    public ElementUtils (WebDriver driver) { this.driver = driver; }
    public WebElement getWebElement (By locator){
        WebElement element = this.waitForElement(locator);
        return element;
    }
    public List<WebElement> getWebElements (By locator){
        return driver.findElements(locator);
    }
    public void sendKey (By locator, String Text){
        this.clearField(locator);
        this.getWebElement(locator).sendKeys(Text);
    }
    public String getTitleOfThePage(){ return this.driver.getTitle(); }
    public void click (By locator){ this.getWebElement(locator).click(); }
    public void click (WebElement element){ element.click(); }
    public String getText (By locator){ return this.getWebElement(locator).getText().trim(); }
    public void clearField(By locator){ this.getWebElement(locator).clear(); }
    public boolean isSelected (By locator){ return this.getWebElement(locator).isSelected(); }
    public boolean isDisPlayed (By locator){ return this.getWebElement(locator).isDisplayed(); }
    public boolean isEnabled (By locator){ return this.getWebElement(locator).isEnabled(); }
    public void selectDropDownValueByVisibleText (By locator, String Text){ new Select(this.getWebElement(locator)).selectByVisibleText(Text); }
    public void selectDropDownValueByText (By locator, String Text){ new Select(this.getWebElement(locator)).selectByValue(Text); }
    public void selectDropDownValueByIndex (By locator, int i){ new Select(this.getWebElement(locator)).selectByIndex(i); }
    public List<String> getAllDropDownValues (By locator){ return new Select(this.getWebElement(locator)).getOptions().parallelStream().map(x->x.getText()).collect(Collectors.toList()); }
    public List<String> getAllSelectedDropDownValues(By locator){ return new Select(this.getWebElement(locator)).getAllSelectedOptions().parallelStream().map(x->x.getText()).collect(Collectors.toList()); }
    public WebElement waitForElementWithFluentWait(By locator, int timeOut, int interval) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
                .withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofSeconds(interval))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }
    public WebElement waitForElement(By locator) {
        wait = new WebDriverWait(this.driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}
