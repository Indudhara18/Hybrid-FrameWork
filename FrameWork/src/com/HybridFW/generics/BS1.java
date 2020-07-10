package com.HybridFW.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

abstract public class BS1 implements IAutoConstant
{
	
	static
	{
		System.setProperty( CHROME_KEY , CHROME_VALUE );			
		System.setProperty( GECKO_KEY , GECKO_VAlUE );
	}
	
	public FUtils tc = new FUtils() ;		


	public static WebDriver driver ;
	
	@BeforeClass
	@Parameters("sBrowser")
	public void openBrowser(String sBrowser)
	{
		
		if (sBrowser.equals("chrome")) 
			driver = new ChromeDriver() ;
			
		else if ( sBrowser.equals("firefox") )	
			driver = new FirefoxDriver() ;
		
		else 
			driver = new InternetExplorerDriver() ;
			
		driver.manage().timeouts().implicitlyWait( ITO , TimeUnit.SECONDS);	
		driver.manage().window().maximize();							
	
		driver.get(URL);	
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
}
