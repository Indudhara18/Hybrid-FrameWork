package com.HybridFW.scripts;

import org.testng.annotations.Test;

import com.HybridFW.generics.Basetest;
import com.HybridFW.pages_Repository.EnterTimeTrackPage;
import com.HybridFW.pages_Repository.LicensesPage;
import com.HybridFW.pages_Repository.LoginPage;

public class TestIssueDate extends Basetest
{
	@Test
	public void test_IssueDate() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.login();
		Thread.sleep(1000);
		
		String expectedTitle = tc.read_XL_Data( XL_DATA_PATH , "IssueDate", 1 , 2 );
		
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		etp.verifyETP(driver, expectedTitle);
		etp.clickOnSettings();
		etp.clickOnLicenses();
		
		String expectedTitleLIP = tc.read_XL_Data( XL_DATA_PATH , "IssueDate", 1, 3);
		String expectedissuedate = tc.read_XL_Data( XL_DATA_PATH , "IssueDate", 1, 4);
		
		LicensesPage lip = new LicensesPage(driver);
		lip.verifyLicensePage(driver, expectedTitleLIP);
		lip.verifyIssueDate(expectedissuedate);
	}
}
