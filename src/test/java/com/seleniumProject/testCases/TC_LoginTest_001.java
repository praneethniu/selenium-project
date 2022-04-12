package com.seleniumProject.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.seleniumProject.pageObjects.PeachHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.seleniumProject.pageObjects.LoginPage;
import com.seleniumProject.testBase.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TC_LoginTest_001 extends BaseClass{

	
	@Test(groups={"sanity","regression","master"})
	public void loginTest() throws Exception
	{
		driver.get(configPropObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.info("**** Providing login details****");

		lp.setUserName(configPropObj.getProperty("useremail"));
		lp.setPassword(configPropObj.getProperty("password"));
		lp.clickLogin();
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,358)");
		Thread.sleep(3000);

		driver.findElement(By.cssSelector(".dAupQY")).click();

		driver.findElement(By.cssSelector(".DatepickerStyles__TodayText-sc-pi6kcl-6")).click();
		Thread.sleep(3000);
		//driver.findElement(By.cssSelector(".react-datepicker__day--013")).click();

		PeachHomePage peachHomePage = new PeachHomePage(driver);
		peachHomePage.pickDate("013");
		peachHomePage.selectRemainingBalance();
		peachHomePage.selectPaymentMethod();

		String parent=driver.getWindowHandle();
		peachHomePage.clickContinue();
		Assert.assertTrue(peachHomePage.isMakePaymentOverlayTextDisplayed(), " make Payment overlay section is not displayed");

		peachHomePage.clickMakePayment();
        Thread.sleep(6000);
		driver.switchTo().window(parent);
		Assert.assertTrue(peachHomePage.isSuccesFulPaymentMessageDisplayed(), " succesful payment method is not displayed");
		peachHomePage.clickDone();
		Assert.assertTrue(peachHomePage.isActivitySectionDisplayed(), " Activity section is not displayed");
	}
}
