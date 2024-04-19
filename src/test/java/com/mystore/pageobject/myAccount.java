package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {
WebDriver ldriver;
	
	public myAccount(WebDriver rdriver)
	{
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@id='email_create']")
    WebElement CreateEmailId;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement CreateAccount;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement RegisterdUserEmail;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement RegisterdUserPassword;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement SignInBtn;
	
	
	public void enterCreateEmailAdress(String emailId)
	{
		CreateEmailId.sendKeys(emailId);
	}
	
	public void clickOnCreateAccount()
	{
		CreateAccount.click();
	}
	
	public void enterEmailId(String emailId)
	{
		RegisterdUserEmail.sendKeys(emailId);
	}
	
	public void enterPassword(String Pwd)
	{
		RegisterdUserPassword.sendKeys(Pwd);
	}
	
	public void ClickOnSignBtn()
	{
		SignInBtn.click();
	}
	
	

}
