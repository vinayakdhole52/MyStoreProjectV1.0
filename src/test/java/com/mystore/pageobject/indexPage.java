package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {

	WebDriver ldriver;
	
	public indexPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "Sign in")
    WebElement signIn;
	
	@FindBy(xpath="(//a[@title='T-shirts'][normalize-space()='T-shirts'])[2]")
	WebElement TshirtMenu;
	
	public void clickOnSignIn()
	{
		signIn.click();
	}
	
	public String getPageTitle()
	{
		return(ldriver.getTitle());
	}
	
	public void clickOnTshirtMenu()
	{
		TshirtMenu.click();
	}
	
}
