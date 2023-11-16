package com.a1qa.a1qademo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import static com.a1qa.a1qademo.constants.Constant.TimeoutVariable.EXPLICIT_WAIT;
import static com.a1qa.a1qademo.constants.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class BrowserFactory {

    public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {

        if (driver == null) {
            if (browserName.equalsIgnoreCase("chrome")) {

                ChromeOptions options = new ChromeOptions();
                options.setPlatformName("ANY");
                options.setBrowserVersion("*");

            /**
                Platform.WIN8
                Platform.WIN10
                Platform.WIN11
                Platform.WINDOWS
                Platform.XP

                Platform.LINUX

                Platform.MAC
                Platform.MONTEREY
                Platform.VENTURA

                Platform.ANY
            **/

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);

            } else {
                System.err.println("Given driver not exist");
            }
        }

        assert driver != null;
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
        }
    }

    public static void closeDriver(WebDriver driver) {
        System.out.println("Closing the browser");
        if (driver != null) {
            driver.close();
        }
    }
}
