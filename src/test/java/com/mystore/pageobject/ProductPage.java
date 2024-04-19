package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

WebDriver ldriver;
	
	public ProductPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//div[@class='selector']/select[@id='group_1']")
    WebElement size;
	
	@FindBy(xpath ="//input[@id='quantity_wanted']")
    WebElement quantity;
	
	@FindBy(name = "Submit")
    WebElement addToCart;
	
	@FindBy(linkText ="Proceed to checkout")
    WebElement proceed;
	
	@FindBy(xpath ="//a[contains(.,'Faded Short Sleeve T-shirts')]")
    WebElement tshirtProduct;
	
	public void selectSize(String sizeType)
	{
		Select s=new Select(size);
		s.selectByVisibleText(sizeType);
	}
	
	public void selectQuantity(String qty)
	{
		quantity.clear();
		quantity.sendKeys(qty);
	}
	
	public void ClickOnAddToCart()
	{
		addToCart.click();
	}
	
	public void clickOnProceedToCheckOut()
	{
		proceed.click();
	}
	
	public void mouseOverOnTshirtProduct()
	{
		Actions act = new Actions(ldriver);
		act.moveToElement(tshirtProduct);
	}
	
}
