package com.HybridFW.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.HybridFW.pages_Repository.EnterTimeTrackPage;

abstract public class Basetest implements IAutoConstant
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
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
	@BeforeMethod
	public void openApplication()
	{
		driver.get(URL);					
	}
	
	
	@AfterMethod
	public void logoutApplication( ITestResult res )
	{	
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		etp.clickOnLogout();
	}
	
}	

