package com.seleniumProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name = \"email\"]")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(xpath = "//input[@name = \"password\"]")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//button[contains(text(), \"Continue\")]")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(linkText = "Logout")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUserName(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}

	public void setPassword(String pwd) {

		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {

		btnLogin.click();
	}

	public void clickLogout() {

		lnkLogout.click();
	}
	
	
}
