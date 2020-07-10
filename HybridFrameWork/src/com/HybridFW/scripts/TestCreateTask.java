package com.HybridFW.scripts;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.HybridFW.generics.Basetest;
import com.HybridFW.pages_Repository.EnterTimeTrackPage;
import com.HybridFW.pages_Repository.LoginPage;
import com.HybridFW.pages_Repository.TaskListPage;

public class TestCreateTask extends Basetest
{

	@Test
	public void test_CreateTask() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.login();
		Thread.sleep(1000);
		
		String expectedTitle = tc.read_XL_Data( XL_DATA_PATH ,"Validcredential", 1, 2);
		
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		etp.verifyETP(driver, expectedTitle);
		etp.clickOnTasksModule();
		Thread.sleep(1000);
		
		String expectedtasklistTitle = tc.read_XL_Data(XL_DATA_PATH ,"TaskListPage", 1, 2);
		
		TaskListPage tlp = new TaskListPage(driver);
		tlp.verifyTaskListPage(driver, expectedtasklistTitle);
		Thread.sleep(500);
		tlp.clickOnAddNewTask();
		Thread.sleep(500);
		tlp.clickOnCreateNewTasks();
		Thread.sleep(500);
		tlp.selectCustomerForTasks(driver, "Dauglass Tyre" );
		Thread.sleep(500);
		tlp.selectProjectForTasks(driver, "Fire Ball");
		

		ArrayList<String> al = new ArrayList<String>();
		al.add("SRS");
		al.add("System Study");
		al.add("Test Cases");
		al.add("Testing");
		al.add("Defect Log and tracking");
		
		tlp.setTaskName(al);
		tlp.clickOnCreateTasksButton();
		
		
	
	}
	
}
