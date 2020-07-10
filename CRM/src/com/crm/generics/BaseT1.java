package com.crm.generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseT1 implements IAutoConstants
{
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	public FWUtils tc = new FWUtils() ;
	
	public static WebDriver driver ;
	
	@BeforeClass
	@Parameters("sbrowser")
	public void openBrowser( String sbrowser )
	{
		if( sbrowser.equals("chrome") )
			driver = new ChromeDriver();
		else
			driver = new FirefoxDriver() ;
	}
	
	@AfterClass
	public void closeBrowser()
	{
//		driver.close();
	}
	
	@BeforeMethod
	public void openApplication()
	{
		driver.get(URL);
	}
}
