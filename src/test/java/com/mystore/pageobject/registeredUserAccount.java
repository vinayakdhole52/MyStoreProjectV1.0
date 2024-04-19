package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registeredUserAccount {

WebDriver ldriver;
	
	public registeredUserAccount(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@title='View my customer account']")
    WebElement username;
	
	@FindBy(linkText ="Sign out")
    WebElement signOut;
	
	@FindBy(xpath = "//input[@name='search_query']")
    WebElement searchBox;
	
	@FindBy(xpath ="//button[@name='submit_search']")
    WebElement searchBtn;
	
	public String getUserName()
	{
		String text=username.getText();
		return text;
	}
	
	public void clickOnSignOut()
	{
		signOut.click();
	}
	
	public void EnterDataInSearchBox(String searchKey)
	{
		searchBox.sendKeys(searchKey);
	}
	
	public void clickOnSearchBtn()
	{
		searchBtn.click();
	}
	
}
	

