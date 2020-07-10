package com.HybridFW.scripts;

import org.testng.annotations.Test;

import com.HybridFW.generics.BS1;
import com.HybridFW.generics.Basetest;
import com.HybridFW.pages_Repository.EnterTimeTrackPage;
import com.HybridFW.pages_Repository.LoginPage;

public class DemoTestLoginPage extends BS1 
{
	@Test( priority = 0 )
	public void validLogin_test() throws InterruptedException
	{
		String expectedtitle = tc.read_XL_Data( XL_DATA_PATH , "Validcredential", 1, 2);
		
		LoginPage lp = new LoginPage(driver);
		lp.login();
		Thread.sleep(1000);
		
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		tc.verifyPage(driver, expectedtitle);
		etp.clickOnLogout();
	}
	
	@Test( priority = 1 )
	public void invalidLogin_test()
	{
		LoginPage lp = new LoginPage(driver);
		lp.login("admin1111", "djfhkdh");
		lp.verifyErrorMessage();
	}
}
