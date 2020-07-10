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
		System.setProperty( CHROME_KEY , CHROME_VALUE );			// Driver Executable path
		System.setProperty( GECKO_KEY , GECKO_VAlUE );
	}
	
	public FUtils tc = new FUtils() ;		// create FWUtilis object to activate all non static methods
	
	public static int passCount = 0 , FailCount = 0 ; 	// To manage test case status
	
	public WebDriver driver ;
	
	@BeforeClass
	@Parameters("sBrowser")
	public void openBrowser(String sBrowser)
	{
		
		if (sBrowser.equals("chrome")) 
			driver = new ChromeDriver() ;									// open the browser
			
		else if ( sBrowser.equals("firefox") )	
			driver = new FirefoxDriver() ;
		
		else 
			driver = new InternetExplorerDriver() ;
			
		driver.manage().timeouts().implicitlyWait( ITO , TimeUnit.SECONDS);	// set browser timeout
		driver.manage().window().maximize();								// and maximise the browser
	
		driver.get(URL);	
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
}
