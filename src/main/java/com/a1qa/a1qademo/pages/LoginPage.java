package com.a1qa.a1qademo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

  @FindBy(xpath = ("//button[contains(text(), Sign in)]"))
  public WebElement signIn;
  @FindBy(xpath = ("//id='join_neu_email_field'"))
  public WebElement login;

  @FindBy(xpath = ("//id='join_neu_password_field'"))
  public WebElement pass;

  @FindBy(xpath = ("//name='submit_attempt'"))
  public WebElement submit;


  public void LoginToEtsy(
      String username,
      String password
  ) throws InterruptedException {
    signIn.click();

    login.sendKeys(username);

    Thread.sleep(1000);
    pass.sendKeys(password);

    Thread.sleep(1000);

    submit.sendKeys(Keys.ENTER);
  }
}
