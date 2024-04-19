package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registeredUserAccount;

public class TC_MyAccountPageTest extends BaseClass {
	
	@Test(enabled = false)
	public void verifyRegistrationAndLogin() 
	{
		
		indexPage ip=new indexPage(driver);
		ip.clickOnSignIn();
		
		myAccount ma=new myAccount(driver);
		ma.enterCreateEmailAdress(emailAddress);
		ma.clickOnCreateAccount();
	
	
	accountCreationDetails accCreationPg=new accountCreationDetails(driver);
	accCreationPg.CreateAnAccount("Vinayak", "Dhole", "Vinayak@52");
	
	registeredUserAccount registerPg=new registeredUserAccount(driver);
	String username=registerPg.getUserName();
	Assert.assertEquals("Vinayak Dhole", username);

	}
	
	@Test
	public void verifyLogin()
	{
		indexPage ip=new indexPage(driver);
		ip.clickOnSignIn();
		
		myAccount ma=new myAccount(driver);
		ma.enterEmailId(emailAddress);
		
		ma.enterPassword(password);
		
		ma.ClickOnSignBtn();
		
		registeredUserAccount registerPg=new registeredUserAccount(driver);
		String username=registerPg.getUserName();
		if(username.equals("Vinayak Dhole"))
		{
			Assert.assertTrue(true);
			
			registerPg.clickOnSignOut();

		}
		
		else
		{
			CaptureScreenshot(driver, "verifyLogin");
			Assert.assertTrue(false);
		}

	}
	
	@Test
	public void verifySignOut()
	{
		indexPage ip=new indexPage(driver);
		ip.clickOnSignIn();
		
		myAccount ma=new myAccount(driver);
		ma.enterEmailId(emailAddress);
		
		ma.enterPassword(password);
		
		ma.ClickOnSignBtn();
		
		registeredUserAccount registerPg=new registeredUserAccount(driver);
		
		registerPg.clickOnSignOut();
		if(ip.getPageTitle().equals("Login - My Shop"))
		{
			Assert.assertTrue(true);
		}
		
		else
		{
			CaptureScreenshot(driver, "verifySignOut");
			Assert.assertTrue(false);
		}

	}
}
