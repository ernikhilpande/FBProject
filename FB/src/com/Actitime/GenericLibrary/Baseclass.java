package com.Actitime.GenericLibrary;

import org.testng.annotations.Test;

import com.Acitime.pom.HomePage;
import com.Acitime.pom.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Baseclass {
	static {
		System.setProperty( "webdriver.chrome.driver",  "./driver/chromedriver.exe");
	}
	
	public WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() throws IOException, InterruptedException {
	  System.out.println("Before method");
	  ReadDataFromProperty rdp=new ReadDataFromProperty();
	  String URL = rdp.readDataFromProperty("url");
	  String UNAME = rdp.readDataFromProperty("username");
	  String PASSW = rdp.readDataFromProperty("password");
	  driver.get(URL);
	  Thread.sleep(5000);
	
	  LoginPage hp=new LoginPage(driver);
	  hp.loginFB(UNAME, PASSW);
	  Thread.sleep(5000);
	  
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  System.out.println("After method");
	  HomePage hp=new HomePage(driver);
	  hp.logout();
	  Thread.sleep(5000);
  }

  @BeforeTest
  public void beforeTest() { // before main method--browser should open first
	  System.out.println("Before Test");
	  driver=new ChromeDriver();
	  driver.manage() .window( ). maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds( 10));
  }

  @AfterTest
  public void afterTest() { // after main method---browser should be close
	  System.out.println("After Test");
	  driver.close();
  }

  @BeforeSuite
  public void beforeSuite() {
	  Reporter.log("Connected Database",true);
  }

  @AfterSuite
  public void afterSuite() {
	  Reporter.log("Diconnected Database",true);
  }

}
