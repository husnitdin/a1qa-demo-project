package com.a1qa.a1qademo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BaseClass{

  public SearchPage(WebDriver driver) {
    this.driver = driver ;
    PageFactory.initElements(driver, this); //initialize the objects
  }

  private final By search = By.id("global-enhancements-search-query");
  private final By hitSearch = By.id("gnav-search-submit-button");

  public void searchFromEtsy(
      String item
  ) throws InterruptedException {

    driver.findElement(search).sendKeys(item);
    Thread.sleep(1000);
    driver.findElement(search).sendKeys(Keys.ENTER);

    //driver.findElement(hitSearch).click();
  }
}
