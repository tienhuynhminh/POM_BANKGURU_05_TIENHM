package com.bankguru.user;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class User_01_RegisterAndLoginToSystem_Level2 {
	WebDriver driver;
	WebDriverWait wait;
	private String userID, password, loginurl;
	private AbstractPage abstractPage;

  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  abstractPage = new AbstractPage();
	  abstractPage.openAnyUrl(driver, "http://www.demo.guru99.com/v4");	
}
  @Test
  public void TC_01_Rigister() {
	  
	  loginurl = abstractPage.getCurrentPageUrl(driver);
	  
	  abstractPage.clickToElement(driver, "//a[text()='here']");
	  System.out.print("Okie 1");
	  
	  abstractPage.waitForControlVisible(driver, "//input[@name='emailid']");
	  System.out.print("Okie 2");
	  
	  abstractPage.senkeyToElement(driver, "//input[@name='emailid']", "tienhm" + randomNumber() + "@gmail.com");
	  System.out.print("Okie 3");
	
	  abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
	  System.out.print("Okie 4");
	  
	  userID = abstractPage.getTextElement(driver, "//td[text()='User ID :']/following-sibling::td");
	  System.out.print("Okie 5");
	  
	  password = abstractPage.getTextElement(driver, "//td[text()='Password :']/following-sibling::td");
	  System.out.print("Okie 6");
	  
  }

  @Test
  public void TC_02_Login() {	  
	  
	  abstractPage.openAnyUrl(driver, loginurl);
	  System.out.print("Okie 7");
	  
	  abstractPage.waitForControlVisible(driver, "//input[@name='uid']");
	  System.out.print("Okie 8");
	  
	  abstractPage.senkeyToElement(driver, "//input[@name='uid']", userID);
	  System.out.print("Okie 9");
	  
	  abstractPage.senkeyToElement(driver, "//input[@name='password']", password);
	  System.out.print("Okie 10");
	  
	  abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
	  System.out.print("Okie 11");
	  
	  Assert.assertTrue(abstractPage.isControlDisplayed(driver, "//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]"));
	  System.out.print("Okie 12");
  }


  @AfterClass
  public void afterClass() {
	  abstractPage.quitBrowser(driver);
  }
  
  public int randomNumber() {
	  Random rand = new Random();
	  int number = rand.nextInt(999999) + 1;
	  return number;
  }
}
