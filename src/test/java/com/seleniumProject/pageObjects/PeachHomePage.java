package com.seleniumProject.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PeachHomePage {

    public WebDriver driver;

    public PeachHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void pickDate(String date) {
        driver.findElement(By.cssSelector(".react-datepicker__day--013")).click();
    }

    public void selectRemainingBalance() {
        driver.findElement(By.cssSelector(".RadioStyles__Container-sc-159rbb2-2:nth-child(2) > .RadioStyles__Label-sc-159rbb2-4")).click();
    }

    public void selectPaymentMethod() {
        driver.findElement(By.xpath("//span[contains(text(),'Select payment method')]")).click();

        driver.findElement(By.cssSelector("#react-select-2-option-1 .getIconWithLabel__Span-sc-di825u-1")).click();
    }

    public void clickContinue() {
        driver.findElement(By.cssSelector(".InfoCardDisclaimer__ButtonGroup-sc-1e6i7he-5 > .secondary")).click();
    }


    public boolean isMakePaymentOverlayTextDisplayed(){
        return driver.findElement(By.xpath("//p[contains(text(),'By clicking Make payment, you authorize PeachyLoan')]")).isDisplayed();

    }

    public void clickMakePayment() {
        driver.findElement(By.cssSelector(".Modal__ModalActions-sc-1iof6kt-6 > .secondary")).click();

    }

    public void clickDone() {
        driver.findElement(By.cssSelector(".iYxwJT")).click();
    }

    public boolean isSuccesFulPaymentMessageDisplayed() {

        return driver.findElement(By.xpath("//span[contains(text(),'Payment was successfully scheduled.')]")).isDisplayed();
    }

    public boolean isActivitySectionDisplayed() {
           return driver.findElement(By.xpath(" //h3[contains(text(),'Activity')]")).isDisplayed();
    }
}
