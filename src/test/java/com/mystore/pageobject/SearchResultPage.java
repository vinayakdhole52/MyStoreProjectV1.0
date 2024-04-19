package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

WebDriver ldriver;
	
	public SearchResultPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "(//a[@title='Faded Short Sleeve T-shirts'])[2]")
    WebElement searchResultProduct;
	
	@FindBy(xpath="//a[@id='color_7']")
    WebElement color;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[2]/a[1]")
  WebElement more;
	
	@FindBy(linkText = "Blouse")
    WebElement blousetext;
	

	public String getSearchResultProductName()
	{
		String text=searchResultProduct.getText();
		return text;
	}
	
	public void ClickOnMoreLink()
	{
		more.click();
	}
	
	public void ClickOnBlouseTextLink()
	{
		blousetext.click();
	}
	
}
