package com.a1qa.a1qademo.pages;

import com.a1qa.a1qademo.utilities.BrowserFactory;
import com.a1qa.a1qademo.utilities.ConfigDataProvider;
import com.a1qa.a1qademo.utilities.ExcelDataProvider;
import com.a1qa.a1qademo.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.io.IOException;
import static com.a1qa.a1qademo.utilities.Helper.getCurrentDateTime;

public class BaseClass {

    protected WebDriver driver;
    protected ExcelDataProvider excel;
    protected ConfigDataProvider config;
    protected ExtentReports reporter;
    protected ExtentTest logger;

    @BeforeSuite
    public void setUpBeforeSuite() {
        excel = new ExcelDataProvider();
        config = new ConfigDataProvider();

        ExtentHtmlReporter extent = new ExtentHtmlReporter(
                new File("./Reports/"
                        + getCurrentDateTime()
                        + ".html"));
        reporter = new ExtentReports();
        reporter.attachReporter(extent);
    }

    @AfterMethod
    public void screenShotBeforeTearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                logger.fail("Test failed",
                        MediaEntityBuilder.createScreenCaptureFromPath(
                                Helper.captureScreenshots(driver)).build());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(result.getStatus() == ITestResult.SUCCESS){
            try {
                logger.pass("Test passed",
                        MediaEntityBuilder.createScreenCaptureFromPath(
                                Helper.captureScreenshots(driver)).build());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(result.getStatus() == ITestResult.SKIP){
            try {
                logger.skip("Test skipped",
                        MediaEntityBuilder.createScreenCaptureFromPath(
                                Helper.captureScreenshots(driver)).build());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        reporter.flush();
    }

    @BeforeClass ( )
    public void setup() {
        driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.closeDriver(driver);
        BrowserFactory.quitBrowser(driver);
    }

}
