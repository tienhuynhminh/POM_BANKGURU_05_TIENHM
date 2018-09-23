package com.bankguru.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class User_01_RegisterAndLoginToSystem_Level1 {
	WebDriver driver;
	WebDriverWait wait;
	private String userID, password, loginurl;

  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  wait = new WebDriverWait(driver,30);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("http://www.demo.guru99.com/v4");	
}
  @Test
  public void TC_01_Rigister() {
	  
	  loginurl = driver.getCurrentUrl(); 
	  
	  driver.findElement(By.xpath("//a[text()='here']")).click();
	  
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name=\"emailid\"]"))));
	  
	  driver.findElement(By.xpath("//input[@name=\"emailid\"]")).sendKeys("tienhm" + randomNumber() + "@gmail.com");
	  
	  driver.findElement(By.xpath("//input[@name=\"btnLogin\"]")).click();
	  
	  userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
	  
	  password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	  
  }

  @Test
  public void TC_02_Login() {
	  
	  driver.get(loginurl);
	  
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='uid']"))));
	  
	  driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
	  
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	  
	  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	  
	  Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).isDisplayed());
	    
  }


  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public int randomNumber() {
	  Random rand = new Random();
	  int number = rand.nextInt(999999) + 1;
	  return number;
  }
}
