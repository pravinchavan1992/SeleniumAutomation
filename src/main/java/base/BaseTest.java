package base;


import config.AppData;
import config.ConfigurationManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import report.ExtentManager;
import utils.Constants;
import utils.ElementUtils;
import utils.OptionsManager;

public class BaseTest {
    public AppData appData = ConfigurationManager.getConfigData().getAppData();
    public WebDriver driver;
    public BasePage page;
    public ElementUtils utils;
    public OptionsManager optionsManager;
    public ExtentManager test;
    @BeforeMethod
    public void setup(){
        this.driver = this.invokeBrowser();
        this.page = new BasePage(this.driver);
        this.utils = new ElementUtils(this.driver);
    }

    private WebDriver invokeBrowser(){
        String browserName = appData.getBrowserName().toLowerCase();
        optionsManager = new OptionsManager();
        switch (browserName){
            case Constants.FF:
                WebDriverManager.firefoxdriver().setup();
                this.driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
                break;
            case Constants.IE:
                WebDriverManager.iedriver().setup();
                this.driver = new InternetExplorerDriver(optionsManager.getInternetExplorerOptions());
                break;
            case Constants.CHROME:
            default:
                WebDriverManager.chromedriver().setup();
                this.driver = new ChromeDriver(optionsManager.getChromeOptions());
        }
        this.driver.manage().deleteAllCookies();
        this.driver.manage().window().maximize();
        this.driver.get(appData.getAppUrl());
        return this.driver;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        this.driver.quit();
    }
}