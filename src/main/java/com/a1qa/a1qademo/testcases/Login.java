package com.a1qa.a1qademo.testcases;

import com.a1qa.a1qademo.pages.BaseClass;
import com.a1qa.a1qademo.pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Login extends BaseClass {

  @Test(priority = 1)
  public void LoginTo() throws InterruptedException {

    logger = reporter.createTest("Login to Etsy");
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    logger.info("Starting the application");

    loginPage.LoginToEtsy(
        excel.getStringData("Login", 0, 1),
        excel.getStringData("Login", 1, 1));

    Alert alert = driver.switchTo().alert();

    String alertText = alert.getText();

    alert.accept();
    System.out.println(alertText);
    logger.pass("Successfully logged in");
  }
}
