package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPaymentPage {
	
WebDriver ldriver;
	
	public OrderPaymentPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@title='Pay by check.']")
    WebElement payByCheck;
	
	@FindBy(xpath ="//a[@title='Pay by bank wire']")
    WebElement payByBankWire;
	
	public void clickOnPayByCheck()
	{
		payByCheck.click();
	}
	
	public void clickOnPayByBankWire()
	{
		payByBankWire.click();
	}

}
