package com.a1qa.a1qademo.testcases;

import com.a1qa.a1qademo.pages.BaseClass;
import com.a1qa.a1qademo.pages.SearchPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class etsy_search extends BaseClass {

  @Test(priority = 1)
  public void SearchItem() throws InterruptedException {

    logger = reporter.createTest("search from Etsy");
    SearchPage etsySearchpage = PageFactory.initElements(driver, SearchPage.class);
    logger.info("Starting the application");

    etsySearchpage.searchFromEtsy(
        excel.getStringData("Items", 0, 0)
    );

    logger.pass("Successfully found the item");
  }
}
