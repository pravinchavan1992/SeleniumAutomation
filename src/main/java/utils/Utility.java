package utils;

import org.openqa.selenium.WebDriver;

public class Utility {
    public static String getTitleOfThePage(WebDriver driver){
        return new ElementUtils(driver).getTitleOfThePage();
    }
}

