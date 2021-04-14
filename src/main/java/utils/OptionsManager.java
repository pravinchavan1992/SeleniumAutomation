package utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class OptionsManager {
    ChromeOptions chromeOptions;
    FirefoxOptions firefoxOptions;
    InternetExplorerOptions internetExplorerOptions;

    public ChromeOptions getChromeOptions(){
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.addArguments("start-maximized");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);
        return chromeOptions;
    }

    public FirefoxOptions getFirefoxOptions(){
        firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("headless");
        firefoxOptions.setAcceptInsecureCerts(true);
        firefoxOptions.addArguments("start-maximized");
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        firefoxOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);
        return firefoxOptions;
    }

    public InternetExplorerOptions getInternetExplorerOptions(){
        internetExplorerOptions = new InternetExplorerOptions();
        firefoxOptions.addArguments("headless");
        internetExplorerOptions.setAcceptInsecureCerts(false);
        internetExplorerOptions.ignoreZoomSettings();
        internetExplorerOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        internetExplorerOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);
        return internetExplorerOptions;
    }
}
