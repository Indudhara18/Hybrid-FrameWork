package com.HybridFW.scripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HybridFW.generics.BS1;
import com.HybridFW.pages_Repository.EnterTimeTrackPage;
import com.HybridFW.pages_Repository.LoginPage;

public class TestLoginPagee extends BS1
{
	@Test(priority = 0)
	public void testValidLoginPage() throws InterruptedException
	{
		String expectedtitle = tc.read_XL_Data( XL_DATA_PATH , "Validcredential", 1, 2);
		
		LoginPage lp = new LoginPage(driver);
		lp.login();
		Thread.sleep(1000);
		
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		etp.verifyETP(driver, expectedtitle);
		Thread.sleep(500);
		etp.clickOnLogout();
	}
	
	@Test(priority = 1 , dataProvider = "invalidData")
	public void testInvalidLoginPage(String un , String pw ) throws InterruptedException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.login(un, pw);
		Thread.sleep(500);
		lp.verifyErrorMessage();
	}
	
	@DataProvider
	public Object[][] invalidData()
	{
		Object[][] o = new Object[3][2] ;
		o[0][0] = "adskljhc" ;
		o[0][1] = "5324sdfvlkj" ;
		
		o[1][0] = "df&&^*(2NB" ;
		o[1][1] = "435" ;

		o[2][0] = "@53274#@HJFVHJ" ;
		o[2][1] = "*(*(^(*^" ; 
		return o ;
	}
	
	
}
