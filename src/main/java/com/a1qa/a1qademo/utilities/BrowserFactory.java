package com.a1qa.a1qademo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import static com.a1qa.a1qademo.constants.Constant.TimeoutVariable.EXPLICIT_WAIT;
import static com.a1qa.a1qademo.constants.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class BrowserFactory {

    public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {

        if(driver==null){
            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

            } else if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            } else {
                System.err.println("Given driver not exist");
            }
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(EXPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appURL);

        return driver;
    }

    public static void quitBrowser(WebDriver driver) {
        System.out.println("Quitting the browser");
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void closeDriver(WebDriver driver) {
        System.out.println("Closing the browser");
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
