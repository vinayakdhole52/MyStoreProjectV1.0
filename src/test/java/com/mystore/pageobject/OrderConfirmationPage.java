package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	
WebDriver ldriver;
	
	public OrderConfirmationPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath ="//span[normalize-space()='I confirm my order']")
    WebElement ConfirmOrder;
	
	@FindBy(xpath ="//div[@id='center_column']/p[@class='alert alert-success']")
    WebElement successAlert;
	
	@FindBy(linkText ="Sign out")
    WebElement SignOut;
	
	public void clickOnConfirmOrder()
	{
		ConfirmOrder.click();
	}
	
	public String getOrderSuccessMessage()
	{
		String text = successAlert.getText();
		return text;
	}
	
	public void clickOnSignOut()
	{
		SignOut.click();
	}

}
