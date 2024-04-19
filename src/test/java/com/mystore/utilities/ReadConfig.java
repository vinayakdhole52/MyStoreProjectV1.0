package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	
	String path = "C:\\Users\\vinay\\Downloads\\eclipse-dsl-2021-09-R-win32-x86_64\\MyStoreV1\\Configuration\\config.properties";
	
	public ReadConfig() 
	{
		properties = new Properties();
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			properties.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public String getBaseUrl()
	{
		String value=properties.getProperty("BaseUrl");
		
		
		if(value!=null)
		{
			return value;
		}
		
		else
			throw new RuntimeException("Url not specified in config file"); 
	}
	
	public String getBrowser()
	{
		String value=properties.getProperty("browser");
		
		
		if(value!=null)
		{
			return value;
		}
		
		else
			throw new RuntimeException("browser not specified in config file"); 
	}
	
	public String getEmail()
	{
		String value=properties.getProperty("email");
		
		
		if(value!=null)
		{
			return value;
		}
		
		else
			throw new RuntimeException("email not specified in config file"); 
	}
	
	public String getPassword()
	{
		String value=properties.getProperty("password");
		
		
		if(value!=null)
		{
			return value;
		}
		
		else
			throw new RuntimeException("password not specified in config file"); 
	}

	
}
