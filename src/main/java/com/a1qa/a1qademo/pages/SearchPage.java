package com.a1qa.a1qademo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BaseClass{

  public SearchPage(WebDriver driver) {
    this.driver = driver ;
    PageFactory.initElements(driver, this);
  }

  @FindBy(id = "global-enhancements-search-query")
  WebElement search;
  @FindBy(xpath = "//span[contains(text(), 'results,')]")
  WebElement numberOfItems;

  @FindBy(xpath = "//*[contains(@class, 'wt-icon--smaller') and contains(@class, 'wt-nudge-t-1')]")
  WebElement xit;

  public void searchFromEtsy(String item) throws InterruptedException {

    search.sendKeys(item, Keys.ENTER);

    String num = numberOfItems.getText().split(" ")[0];

    Thread.sleep(2000);

    System.out.println("In etsy, there are " + num + " " + item+"s");

    xit.click();
    Thread.sleep(2000);
  }
}