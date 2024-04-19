package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registeredUserAccount;
import com.mystore.utilities.ReadExcelFile;

public class TC_MyAccountPageTestDataDrivenTesting extends BaseClass {
	
	@Test(enabled = false)
	public void verifyRegistrationAndLogin() 
	{
		
		indexPage ip=new indexPage(driver);
		ip.clickOnSignIn();
		
		myAccount ma=new myAccount(driver);
		ma.enterCreateEmailAdress("cs123@gamil.com");
		ma.clickOnCreateAccount();
	
	
	accountCreationDetails accCreationPg=new accountCreationDetails(driver);
	accCreationPg.CreateAnAccount("Vinayak", "Dhole", "Vinayak@52");
	
	registeredUserAccount registerPg=new registeredUserAccount(driver);
	String username=registerPg.getUserName();
	Assert.assertEquals("Vinayak Dhole", username);

	}
	
	@Test(dataProvider = "LoginDataProvider")
	public void verifyLogin(String userEmail, String userPwd, String expectedUsername)
	{
		indexPage ip=new indexPage(driver);
		ip.clickOnSignIn();
		
		myAccount ma=new myAccount(driver);
		ma.enterEmailId(userEmail);
		
		ma.enterPassword(userPwd);
		
		ma.ClickOnSignBtn();
		
		registeredUserAccount registerPg=new registeredUserAccount(driver);
		String username=registerPg.getUserName();
		if(username.equals(expectedUsername))
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
	
	@DataProvider
	public String[][] LoginDataProvider()
	{
		String fileName = System.getProperty("user.dir")+"\\TestData\\MystoreTestData.xlsx";
		
		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
		
		String data[][] = new String [ttlRows-1][ttlColumns];
		
		for(int i=1; i<ttlRows; i++)
		{
			for(int j=0; j<ttlColumns; j++)
			{
				data[i-1][j]=ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
			}
		}
		
		return data;
	}
}
