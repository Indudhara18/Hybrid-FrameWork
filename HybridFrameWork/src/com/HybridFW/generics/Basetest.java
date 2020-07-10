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
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
	@BeforeMethod
	public void openApplication()
	{
		driver.get(URL);					//  open the application 
	}
	
	/**
	 * Take Screenshot if Testcase is failed
	 * @param res
	 */
	@AfterMethod
	public void logoutApplication( ITestResult res )
	{
		int testStatus = res.getStatus();
		String testName = res.getName();
		
		if ( testStatus == 1 ) 
		{
			passCount++ ;
		}
		else
		{
			FailCount++ ;
			String ppath = PHOTO_PATH + testName + ".png" ;
			tc.takeScreenShot(driver, ppath);
			
		}
		
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		etp.clickOnLogout();
	}
	
	@AfterSuite
	public void print()
	{
		Reporter.log("pass : " + passCount , true);
		Reporter.log("Fail : " + FailCount , true);
		tc.write_XL_Data(XL_RESULT_PATH, "sheet1", 1 , 0 , passCount);
		tc.write_XL_Data1(XL_RESULT_PATH, "sheet1", 1 , 1 , FailCount);
	}

}	

