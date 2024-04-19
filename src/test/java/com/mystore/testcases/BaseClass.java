package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mystore.utilities.ReadConfig;

public class BaseClass {
	
    public static WebDriver driver;
	
	ReadConfig readconfig=new ReadConfig();
	
	String url=readconfig.getBaseUrl();
	String browser=readconfig.getBrowser();
	String emailAddress=readconfig.getEmail();
	String password=readconfig.getPassword();
	
	@BeforeClass
	public void Setup()
	{
		
		switch (browser.toLowerCase()) {
		case "chrome":
			driver=new ChromeDriver();
			break;
			
		case "msedge":
			driver=new EdgeDriver();
			break;
			
		case "firefox":
			driver=new FirefoxDriver();
			break;

		default:
			driver=null;
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(url);
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
	
	public void CaptureScreenshot(WebDriver driver, String testName)
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest=new File(System.getProperty("user.dir") + "//screenshots//" + testName + ".png");
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}
