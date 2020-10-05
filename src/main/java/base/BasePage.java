package base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import report.ExtentManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class BasePage extends Page{
    WebDriver driver;
    Properties prop;
    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public Properties init_Properties()  {
        prop = new Properties();
        String env = System.getenv("env");
        Path path = Paths.get(System.getProperty("user.dir"),"src","main","java","config","config.properties");
        try {
            FileInputStream in = new FileInputStream(String.valueOf(path));
            prop.load(in);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    @Override
    public String getTitleOfthePage() { return utils.getTitleOfThePage(); }

    @Override
    public WebElement getWebElement(By locator) { return utils.getWebElement(locator); }

    public String moveToElementAndGetText(By locator) {
        Actions actions = new Actions(this.driver);
        actions.moveToElement(this.getWebElement(locator)).build().perform();
        return this.getWebElement(locator).getText();
    }

    @Override
    public void enterText(By locator, String Text) { utils.sendKey(locator, Text); }

    @Override
    public void clickOn(By locator) { utils.click(locator); }

    public void clickOn(WebElement element) { utils.click(element); }
    @Override
    public String getText(By locator) { return utils.getText(locator); }

    @Override
    public void clearField(By locator) { utils.clearField(locator); }

    @Override
    public boolean isSelected(By locator) { return utils.isSelected(locator); }

    @Override
    public boolean isDisPlayed(By locator) { return utils.isDisPlayed(locator); }

    @Override
    public boolean isEnabled(By locator) { return utils.isEnabled(locator); }

    @Override
    public void selectDropDownValueByVisibleText(By locator, String Text) { utils.selectDropDownValueByVisibleText(locator,Text); }

    @Override
    public void selectDropDownValueByText(By locator, String Text) { utils.selectDropDownValueByText(locator,Text); }

    @Override
    public void selectDropDownValueByIndex(By locator, int i) { utils.selectDropDownValueByIndex(locator,i); }

    @Override
    public List<String> getAllDropDownValues(By locator) { return utils.getAllDropDownValues(locator); }

    @Override
    public List<String> getAllSelectedDropDownValues(By locator) { return utils.getAllSelectedDropDownValues(locator);  }

    @Override
    public WebElement waitForElementWithFluentWait(By locator, int timeOut, int interval) { return utils.waitForElementWithFluentWait(locator, timeOut, interval); }

    @Override
    public WebElement waitForElement(By locator) { return utils.waitForElement(locator); }

    @Override
    public void waitForPageLoaded() { utils.waitForPageLoaded(); }

    @Override
    public List<String> getLinkListText(By locator) { return utils.getWebElements(locator).stream().map(x->x.getText()).collect(Collectors.toList()); }

    public List<WebElement> getLinkList(By locator) { return utils.getWebElements(locator).stream().collect(Collectors.toList()); }

    public void moveToElement(By locator){
        Actions action = new Actions(this.driver);
        action.moveToElement(this.getWebElement(locator)).build().perform();
    }
}
