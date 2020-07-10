package com.crm.generics ;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.crm.pages.HomePage;

/**
 * This class is used as PreCondition and PostCondition for this project 
 * @author Indudhara
 *
 */

 public class BaseTest implements IAutoConstants
{

	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	public FWUtils tc = new FWUtils();
	
	public static WebDriver driver ;
	
	@BeforeClass
	@Parameters("sbrowser")
	public void openBrowser(String sbrowser)
	{
		if ( sbrowser.equals( "chrome" ) ) 
			driver = new ChromeDriver() ;
		else
			driver = new FirefoxDriver() ;
		
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void closeBrowser()
	{
//		driver.close();
	}
	
	@BeforeMethod
	public void openApplication()
	{
		driver.get( URL );		
	}
	
	@AfterMethod
	public void logOut()
	{
	    HomePage hp = new HomePage(driver);
//	    hp.clickLogout();
	}
	
}
