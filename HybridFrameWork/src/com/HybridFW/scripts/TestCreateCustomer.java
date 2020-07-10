package com.HybridFW.scripts;

import org.testng.annotations.Test;

import com.HybridFW.generics.Basetest;
import com.HybridFW.pages_Repository.EnterTimeTrackPage;
import com.HybridFW.pages_Repository.LoginPage;
import com.HybridFW.pages_Repository.TaskListPage;

public class TestCreateCustomer extends Basetest
{

	@Test
	public void test_CreateCustomer() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.login();
		Thread.sleep(1000);
		

		String expectedTitle = tc.read_XL_Data( XL_DATA_PATH ,"Validcredential", 1, 2);
		
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		etp.verifyETP(driver, expectedTitle);
		etp.clickOnTasksModule();
		Thread.sleep(1000);
		
		String expectedtasklistTitle = tc.read_XL_Data( XL_DATA_PATH , "TaskListPage", 1, 2);
		
		TaskListPage tlp = new TaskListPage(driver);
		tlp.verifyTaskListPage(driver, expectedtasklistTitle);
		tlp.clickOnAddNewButton();
		Thread.sleep(500);
		tlp.clickOnNewCustomerButton();
		tlp.setCustomerName("Dauglass Tyre");
		tlp.setCustomerDescription("They need stable product at the end of this year");
		tlp.clickOnCreateCustomerButton(driver);
		Thread.sleep(1000);
		tlp.verifyCustomerIsCreated(driver ,"Dauglass Tyre");	
	
	}
	
}
