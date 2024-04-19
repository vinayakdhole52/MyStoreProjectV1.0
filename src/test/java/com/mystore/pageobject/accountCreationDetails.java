package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountCreationDetails {

WebDriver ldriver;
	
	public accountCreationDetails(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@id='id_gender1']")
    WebElement titleMr;
	
	@FindBy(xpath = "//input[@id='customer_firstname']")
    WebElement firstName;
	
	@FindBy(xpath = "//input[@id='customer_lastname']")
    WebElement lastName;
	
	@FindBy(xpath = "//input[@id='passwd']")
    WebElement password;
	
	@FindBy(xpath="//button[@id='submitAccount']")
	WebElement Register;
	
	
	public void CreateAnAccount(String fname, String lname, String pwd)
	{
		titleMr.click();
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		password.sendKeys(pwd);
		Register.click();
	}
	
	
	

	
}
