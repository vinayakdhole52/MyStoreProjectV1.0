package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.mystore.pageobject.OrderAddressPage;
import com.mystore.pageobject.OrderConfirmationPage;
import com.mystore.pageobject.OrderPaymentPage;
import com.mystore.pageobject.OrderShippingPage;
import com.mystore.pageobject.OrderSummaryPage;
import com.mystore.pageobject.ProductPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registeredUserAccount;



public class TC_ProductPageTest extends BaseClass {
	
	    @Test
		public void VerifySearchProduct()
		{
			String searchKey="T-shirts";
			
			indexPage ip=new indexPage(driver);
			ip.clickOnSignIn();
			
			myAccount ma=new myAccount(driver);
			ma.enterEmailId(emailAddress);
			
			ma.enterPassword(password);
			
			ma.ClickOnSignBtn();
			
			registeredUserAccount productPg=new registeredUserAccount(driver);
			
			productPg.EnterDataInSearchBox(searchKey);
			productPg.clickOnSearchBtn();
			
			SearchResultPage resultPg=new SearchResultPage(driver);
			String SearchResultProductName=resultPg.getSearchResultProductName();
			
			if(SearchResultProductName.contains(searchKey))
			{
				Assert.assertTrue(true);
				productPg.clickOnSignOut();
			}
			
			else
			{
				CaptureScreenshot(driver, "VerifySearchProduct");
				Assert.assertTrue(false);
			}
			
		}
	    
	    @Test
		public void VerifyBuyProduct() throws InterruptedException
		{
			String searchKey="Blouse";
			
			indexPage ip=new indexPage(driver);
			ip.clickOnSignIn();
			
			myAccount ma=new myAccount(driver);
			ma.enterEmailId(emailAddress);
			
			ma.enterPassword(password);
			
			ma.ClickOnSignBtn();
			
			registeredUserAccount productCatPg=new registeredUserAccount(driver);
			
			productCatPg.EnterDataInSearchBox(searchKey);
			productCatPg.clickOnSearchBtn();
			
			SearchResultPage searchResultPg = new SearchResultPage(driver);
			searchResultPg.ClickOnBlouseTextLink();
			
		Thread.sleep(4000);
		
		ProductPage productPg = new ProductPage(driver);
		
			productPg.selectSize("M");
			
			productPg.selectQuantity("2");
			
			productPg.ClickOnAddToCart();
			
			productPg.clickOnProceedToCheckOut();
			
			OrderSummaryPage orderSumPg = new OrderSummaryPage(driver);
			orderSumPg.clickOnProceedToCheckOut();
			
			OrderAddressPage orderAddPg = new OrderAddressPage(driver);
			orderAddPg.clickOnProceedToCheckOut();
			
			OrderShippingPage orderShipPg = new OrderShippingPage(driver);
			orderShipPg.selectTermsOfService();
			orderShipPg.clickOnProceedToCheckOut();
			
			OrderPaymentPage orderPaymentPg = new OrderPaymentPage(driver);
			orderPaymentPg.clickOnPayByCheck();
			
			OrderConfirmationPage orderConfirmPg = new OrderConfirmationPage(driver);
			orderConfirmPg.clickOnConfirmOrder();
			
			String successMsg = orderConfirmPg.getOrderSuccessMessage();
			
			if(successMsg.equals("Your order on My Shop is complete."))
			{
				Assert.assertTrue(true);
				orderConfirmPg.clickOnSignOut();
			}
			
			else
			{
				CaptureScreenshot(driver, "VerifyBuyProduct");
				Assert.assertTrue(false);
			}
			
		}	
	
}
